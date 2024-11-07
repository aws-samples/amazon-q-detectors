// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0



// {fact rule=kotlin-null-pointer-dereference@v1.0 defects=1}
import java.nio.ByteBuffer

// Noncompliant: Dereferencing freed pointer.
fun null_pointer_dereference_noncompliant() {
    val byteBuffer = ByteBuffer.allocateDirect(Int.SIZE_BYTES)
    val ptr = byteBuffer.asIntBuffer()
    byteBuffer.clear()
    val value = ptr[0] 
}
// {/fact}
