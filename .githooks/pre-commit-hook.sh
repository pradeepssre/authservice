#!/bin/sh

echo "Running pre-commit hook..."
echo "Running mvn validate..."

# Stash changes not in staging area
git stash -q --keep-index

# Run validation
./mvnw validate

# Store the exit code
RESULT=$?

# Restore stashed changes
git stash pop -q

# If validation failed, exit with error
if [ $RESULT -ne 0 ]; then
  echo "Pre-commit hook failed. Please fix the issues before committing."
  exit 1
fi

exit 0
