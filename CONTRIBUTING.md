# Contributing Guidelines

## Code Style

### Kotlin
- Follow official Kotlin style guide
- Use meaningful variable names
- Keep functions under 50 lines when possible
- Add documentation comments for public functions

### Compose
- One Composable per file when possible
- Use preview annotations for testing UI
- Keep Composables pure and side-effect free
- Avoid nested Composables if reusable

### Naming Conventions
- Activities: `*Activity` (e.g., `MainActivity`)
- Composables: `*Screen` or component name (e.g., `HomeScreen`)
- ViewModels: `*ViewModel` (e.g., `ChannelViewModel`)
- Repositories: `*Repository` (e.g., `ChannelRepository`)
- Utilities: `*Util` (e.g., `DateUtil`)

## Branching Strategy

- Main branch: production-ready code
- Develop branch: integration branch
- Feature branches: `feature/description`
- Bugfix branches: `bugfix/description`
- Hotfix branches: `hotfix/description`

## Commit Messages

```
[TYPE] Brief description

Optional detailed explanation
```

Types:
- `feat`: New feature
- `fix`: Bug fix
- `refactor`: Code refactoring
- `docs`: Documentation
- `style`: Code style changes
- `test`: Test additions

## Pull Request Process

1. Create feature branch from `develop`
2. Make changes with descriptive commits
3. Write/update tests
4. Update documentation
5. Create pull request with clear description
6. Address review comments
7. Merge after approval

## Testing

- Write unit tests for utilities and ViewModels
- Write integration tests for repositories
- Add Compose UI tests for screens
- Maintain >80% code coverage

## Documentation

- Update README for significant changes
- Add code comments for complex logic
- Document API endpoints
- Keep SETUP.md current

## Performance

- Profile apps with Android Profiler
- Avoid unnecessary recompositions
- Use LazyColumn/LazyRow for lists
- Implement proper caching
- Monitor memory usage

## Accessibility

- Add content descriptions to icons
- Use proper text contrast ratios
- Support screen readers
- Test with accessibility tools

## Security

- Never commit secrets or API keys
- Use environment variables for configuration
- Validate user inputs
- Implement proper authentication
- Use HTTPS for all network calls
