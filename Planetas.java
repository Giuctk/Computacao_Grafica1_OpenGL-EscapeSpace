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
 * @author Giuliano Cesari Tacioli_130854
 */

public class Planetas {

    double[] valX = {-3, 8, -7, -12, -8, 3, 5, 13};
    double[] valY = {11, 4, 13,  9,  4,  3, 7, 12};
    
    public void desenhar(GLUT glut, GL2 gl){
        planetaDown(glut, gl);
        planetaLeft(glut, gl);
        planetasFundo(glut, gl);
        //desenhaEstrelas(glut, gl);
    }
        
    public void planetaDown(GLUT glut, GL2 gl){
        gl.glPushMatrix();
            gl.glTranslated(0, -20, -10);
            gl.glColor3d(0.367 , 0.2 , 0.09);
            glut.glutSolidSphere(18.0,100,100);
            gl.glColor3d(1, 1, 1);
        gl.glPopMatrix();
        gl.glPushMatrix();
            gl.glTranslated(0, -21, -11);
            gl.glColor3d(1 , 1 , 1);
            glut.glutSolidSphere(18.8,100,100);
            gl.glColor3d(1, 1, 1);
        gl.glPopMatrix();
    }
    
    public void planetaLeft(GLUT glut, GL2 gl){
        gl.glPushMatrix();
            gl.glTranslated(-9, 11, -10);
            gl.glColor3d(0.137255  , 0.556863    , 0.419608);
            glut.glutSolidSphere(3.0,100,100);
            gl.glColor3d(1, 1, 1);
        gl.glPopMatrix();
    }
    
    public void planetasFundo(GLUT glut, GL2 gl){
        gl.glPushMatrix();
            gl.glTranslated(11, 9, -20);
            gl.glColor3d(0.5, 0.0, 0.0);
            glut.glutSolidSphere(1.0,100,100);
            gl.glColor3d(1, 1, 1);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
            gl.glTranslated(2, 12, -20);
            gl.glColor3d(0.5 , 0.5, 0.5);
            glut.glutSolidSphere(2.0,100,100);
            gl.glColor3d(1, 1, 1);
        gl.glPopMatrix();
        gl.glPushMatrix();
            gl.glTranslated(1.0, 11.6, -17);
            gl.glColor3d(0.4 , 0.4, 0.4);
            glut.glutSolidSphere(0.5,100,100);
            gl.glColor3d(1, 1, 1);
        gl.glPopMatrix();
        gl.glPushMatrix();
            gl.glTranslated(1.6, 10, -15);
            gl.glScaled(3.2,0.1,0.1);
            gl.glColor3d(0.7 , 0.7, 0.7);
            glut.glutSolidCube(1);
        gl.glPopMatrix();        
    }
        
    public void desenhaEstrelas(GLUT glut, GL2 gl){
        for(int i = 0; i< 8 ; i++){
            gl.glPushMatrix();
            gl.glTranslated(valX[i], valY[i], -22.98);
            gl.glColor3d(1 , 1 , 1);
            glut.glutSolidSphere(0.995,100,100);
        gl.glPopMatrix();
        gl.glPushMatrix();
            gl.glTranslated(valX[i], valY[i], -24);
            gl.glColor3d(0.3 , 0.3 , 0.3);
            glut.glutSolidSphere(2.013,100,100);
        gl.glPopMatrix();
        }        
    }
}
