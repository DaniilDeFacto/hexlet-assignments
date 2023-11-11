@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage page

@template.layout.page(
    content = @`
        @if(page.getError() != null)
            <h3>${page.getError()}</h3>
        @endif
        <form action="${NamedRoutes.loginPath()}" method="post">
            <input type="text" placeholder="Name" name="name" />
            <input type="password" placeholder="Password" name="password" />
            <input type="submit" />
        </form>
    `
)
