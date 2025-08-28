// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-csrf-disabled-ide@v1.0 defects=1}
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.sessions.*

fun csrfDisabledNonCompliant() {
    embeddedServer(Netty, port = 8080) {
        install(Sessions) {
            cookie<UserSession>("USER_SESSION")
        }
        
        routing {
            post("/transfer") {
                val amount = call.receiveParameters()["amount"]
                val toAccount = call.receiveParameters()["toAccount"]
                
                // Noncompliant: No CSRF token validation before performing sensitive operation.
                performTransfer(amount, toAccount)
                call.respondText("Transfer completed")
            }
        }
    }.start(wait = true)
}
// {/fact}
