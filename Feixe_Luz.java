/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_EscapeSpace_130854;

import com.jogamp.opengl.util.gl2.GLUT;
import javax.media.opengl.GL2;

/**
 *
 * @author Giuliano Cesari Tacioli _ 130854
 */
public class Feixe_Luz {
    
    private double x, y, z=-10, inicialZ;
    
    public void desenhaFeixeLuz(GLUT glut, GL2 gl){
        gl.glPushMatrix();
          gl.glPushMatrix();
            gl.glTranslated(x, y, z);
            gl.glScaled(0.01,0.01,1);
            glut.glutSolidCube(1);
          gl.glPopMatrix();
        gl.glPopMatrix();
    }
    

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    } 
}
