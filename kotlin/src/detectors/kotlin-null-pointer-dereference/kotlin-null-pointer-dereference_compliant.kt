// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-null-pointer-dereference@v1.0 defects=0}
import java.nio.ByteBuffer

// Compliant: Added a null check before dereferencing the pointer.
fun null_pointer_dereference_compliant() {
    val byteBuffer = ByteBuffer.allocateDirect(Int.SIZE_BYTES)
    val ptr = byteBuffer.asIntBuffer()
    if(ptr != null) {
        val value = ptr[0] 
        byteBuffer.clear()
    }
}
// {/fact}
