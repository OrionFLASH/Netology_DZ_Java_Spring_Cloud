#!/usr/bin/env bash
# Интеграционная проверка Spring Cloud Config.
# Требует запущенный Config Server на порту 8888.
# Config Client проверяется только если уже запущен на 8080.

set -euo pipefail

CONFIG_SERVER="${CONFIG_SERVER:-http://localhost:8888}"
CONFIG_CLIENT="${CONFIG_CLIENT:-http://localhost:8080}"

pass=0
fail=0

check() {
  local name="$1"
  local result="$2"
  if [[ "$result" == "ok" ]]; then
    echo "[PASS] $name"
    pass=$((pass + 1))
  else
    echo "[FAIL] $name — $result"
    fail=$((fail + 1))
  fi
}

echo "=== Config Server (8888) ==="
for profile in default dev prod; do
  response="$(curl -sf "${CONFIG_SERVER}/config-client/${profile}" 2>/dev/null || echo "")"
  if [[ -n "$response" ]] && echo "$response" | grep -q '"name":"config-client"'; then
    check "GET /config-client/${profile}" "ok"
  else
    check "GET /config-client/${profile}" "нет ответа или неверный JSON"
  fi
done

health="$(curl -sf "${CONFIG_SERVER}/actuator/health" 2>/dev/null || echo "")"
if echo "$health" | grep -q '"status":"UP"'; then
  check "Config Server health" "ok"
else
  check "Config Server health" "status != UP"
fi

echo ""
echo "=== Config Client (8080, опционально) ==="
client_response="$(curl -sf "${CONFIG_CLIENT}/api/config/message" 2>/dev/null || echo "")"
if [[ -n "$client_response" ]] && echo "$client_response" | grep -q '"message"'; then
  check "GET /api/config/message" "ok"
  client_health="$(curl -sf "${CONFIG_CLIENT}/actuator/health" 2>/dev/null || echo "")"
  if echo "$client_health" | grep -q '"status":"UP"'; then
    check "Config Client health" "ok"
  else
    check "Config Client health" "status != UP"
  fi
else
  echo "[SKIP] Config Client не запущен — проверьте вручную с профилями dev/prod"
fi

echo ""
echo "Итого: ${pass} успешно, ${fail} ошибок"
[[ "$fail" -eq 0 ]]
