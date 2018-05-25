package se.an3ll.jooby.webapp

import org.jooby.Jooby.run
import org.jooby.Kooby
import org.jooby.apitool.ApiTool
import org.jooby.require


class App : Kooby({

    bind(UserHandler())

    path("/rest") {
        path("/users") {
            get {
                require(UserHandler::class).test()
            }
        }
    }

    use(ApiTool()
        .swagger("/swagger")
        .raml("/raml")
    )
})

fun main(args: Array<String>) {
    run(::App, args)
}