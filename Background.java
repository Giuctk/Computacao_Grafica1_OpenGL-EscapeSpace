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
public class Background{
    
    private double r=0, g=0, b=0;
    private boolean escuro = true;
    
    public void desenhaBackground(GLUT glut, GL2 gl){
        gl.glPushMatrix();
            gl.glTranslated(0, 12, -22);
            gl.glScaled(40, 45, 0);
            gl.glColor3d(r, g, b);
            glut.glutSolidCube(1);
            gl.glColor3d(1, 1, 1);
        gl.glPopMatrix();
        
        if(escuro){
            r += 0.001;
            g += 0.001;
            b += 0.003;
        }        
        
        if(r >= 0.1 || g >= 0.1 || b >= 0.3)
            escuro = false;
        
        if(escuro == false){
            r -= 0.001;
            g -= 0.001;
            b -= 0.003;
        }
        
        if(r <= 0 || g <= 0 || b <= 0)
            escuro = true;
    }
       
    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
}
