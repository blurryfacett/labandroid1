package com.example.labandroid1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;

public class kvadrat {
    FloatBuffer f, clr;
    ByteBuffer b;
    float[] cord = new float[]{
            -1, -1.5f, 0,
            -1, -3.5f, 0,
             1, -3.5f, 0,
             1, -1.5f, 0
    };
    float[] cl = new float[]{
            0, 1, 0, 1,
            0, 1, 0, 1,
            0, 1, 0, 1,
            0, 1, 0, 1
    };
    public kvadrat() {
        b=ByteBuffer.allocateDirect(4*3*4);
        b.order(ByteOrder.nativeOrder());
        f=b.asFloatBuffer();
        f.put(cord);
        f.position(0);
        b=ByteBuffer.allocateDirect(4*4*4);
        b.order(ByteOrder.nativeOrder());
        clr=b.asFloatBuffer();
        clr.put(cl);
        clr.position(0);
    }

    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3,GL10.GL_FLOAT,0,f);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        gl.glColorPointer(4,GL10.GL_FLOAT,0,clr);
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN,0,4);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
    }
}
