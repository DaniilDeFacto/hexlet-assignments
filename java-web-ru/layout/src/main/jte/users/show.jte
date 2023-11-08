@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
content = @`
    <h1>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h1>
    <h2>ID: ${page.getUser().getId()}</h2>
    <h2>Email: ${page.getUser().getEmail()}</h2>
`
)
