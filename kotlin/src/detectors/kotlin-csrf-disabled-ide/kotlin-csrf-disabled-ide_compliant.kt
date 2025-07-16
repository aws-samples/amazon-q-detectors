// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-csrf-disabled-ide@v1.0 defects=0}
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.sessions.*
import io.ktor.http.*

fun csrfDisabledCompliant() {
    embeddedServer(Netty, port = 8080) {
        install(Sessions) {
            cookie<UserSession>("USER_SESSION")
        }
        
        routing {
            post("/transfer") {
                val user = call.sessions.get<UserSession>()
                val csrfToken = call.request.headers["X-CSRF-Token"]
                
                // Compliant: Validating CSRF token before performing sensitive operation.
                if (user != null && csrfToken == user.csrfToken) {
                    val amount = call.receiveParameters()["amount"]
                    val toAccount = call.receiveParameters()["toAccount"]
                    
                    performTransfer(amount, toAccount)
                    call.respondText("Transfer completed")
                } else {
                    call.respond(HttpStatusCode.Forbidden, "Invalid CSRF token")
                }
            }
        }
    }.start(wait = true)
}
// {/fact}
