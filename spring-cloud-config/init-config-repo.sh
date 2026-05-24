#!/usr/bin/env bash
# Инициализирует локальный git-репозиторий config-repo, если он ещё не создан.
# Необходимо для работы Spring Cloud Config Server с file:// URI.

set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
CONFIG_REPO="${SCRIPT_DIR}/config-repo"

if [[ -d "${CONFIG_REPO}/.git" ]]; then
  echo "config-repo уже инициализирован: ${CONFIG_REPO}"
  exit 0
fi

echo "Инициализация git-репозитория config-repo..."
cd "${CONFIG_REPO}"
git init -b main
git add .
git commit -m "Initial config files for config-client application"
echo "Готово: ${CONFIG_REPO}"
