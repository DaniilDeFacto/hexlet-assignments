@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(
    content = @`
        <main>
            @if(page.getName() != null)
                <h3>${page.getName().toString()}</h3>
                <a href="${NamedRoutes.logoutPath()}">Выйти</a>
            @else
                <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
            @endif
        </main>
    `
)