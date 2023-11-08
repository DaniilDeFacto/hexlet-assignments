@import exercise.dto.users.UserPage
@param UserPage page

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
              crossorigin="anonymous">
        <title>Хекслет</title>
    </head>
    <body>
        <main>
            <div class="mx-auto p-4 py-md-5">
                <h1>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h1>
                <h2>ID: ${page.getUser().getId()}</h2>
                <h2>Email: ${page.getUser().getEmail()}</h2>
            </div>
        </main>
    </body>
</html>
