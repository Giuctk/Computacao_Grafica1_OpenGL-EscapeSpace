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
public class Objeto {
    
    private double incX=0, velZ = 0, posZ=0, posY=0, posX=-2.2, r, g, b;
    private int valorAsteroide;    
    
    public void desenhaPlayer(GLUT glut, GL2 gl){
        gl.glPushMatrix();
          gl.glPushMatrix();
            gl.glTranslated(posX, posY, 0);
            gl.glScaled(0.4,0.3,1);
            gl.glColor3d(0.125, 0.2, 0.584);
            glut.glutSolidCube(1);
          gl.glPopMatrix();
          gl.glPushMatrix();
            gl.glTranslated(posX, posY+0.2, -0.2);
            gl.glScaled(0.4,0.3,1);
            gl.glColor3d(1, 1, 1);
            glut.glutSolidCylinder(0.37,0.28,100,100);
          gl.glPopMatrix();
          gl.glPushMatrix();
          gl.glColor3d(0.050, 0.082, 0.25);
          gl.glBegin(GL2.GL_TRIANGLES);          
           gl.glVertex3d(posX-0.6, posY, 0);
           gl.glVertex3d(posX+0.6, posY, 0);
           gl.glVertex3d(posX-0.0, posY, -0.8);
        gl.glEnd();
          gl.glPopMatrix();
          gl.glPushMatrix();
            gl.glTranslated(posX-0.1, posY+0.15, 0.3);
                gl.glScaled(0.04,0.06,0.4);
                gl.glColor3d(1, 0, 0); 
                glut.glutSolidCube(1);
          gl.glPopMatrix();
          gl.glPushMatrix();
            gl.glTranslated(posX+0.1, posY+0.15, 0.3);
                gl.glScaled(0.04,0.06,0.4);
                gl.glColor3d(1, 0, 0); 
                glut.glutSolidCube(1);
          gl.glPopMatrix();
          gl.glPushMatrix();
            gl.glTranslated(posX-0.1, posY+0, 0.3);
                gl.glScaled(0.15,0.2,0.41);
                gl.glColor3d(0, 0, 0); 
                glut.glutSolidCube(1);
          gl.glPopMatrix();
          gl.glPushMatrix();
            gl.glTranslated(posX+0.1, posY+0, 0.3);
                gl.glScaled(0.15,0.2,0.41);
                gl.glColor3d(0, 0, 0); 
                glut.glutSolidCube(1);
          gl.glPopMatrix();
          gl.glPushMatrix();
            gl.glTranslated(posX-0.1, posY+0, 0.3);
                gl.glScaled(0.06,0.1,0.43);
                gl.glColor3d(1, 0, 0); 
                glut.glutSolidCube(1);
          gl.glPopMatrix();
          gl.glPushMatrix();
            gl.glTranslated(posX+0.1, posY+0, 0.3);
                gl.glScaled(0.06,0.1,0.43);
                gl.glColor3d(1, 0, 0); 
                glut.glutSolidCube(1);
          gl.glPopMatrix();
          gl.glColor3d(1, 1, 1);

    }
    
    public void desenhaAsteroide(GLUT glut, GL2 gl){
          gl.glPushMatrix();
            gl.glTranslated(posX, posY, posZ - 40);
            gl.glScaled(1,1,1);
            gl.glRotated(getVelZ(), 1, 1, 1);
            gl.glColor3d(r, g, b);
            glut.glutSolidIcosahedron();
          gl.glPopMatrix();          
    }
    
    
    public void desenhaVidas(GLUT glut, GL2 gl){
        gl.glPushMatrix();
          gl.glPushMatrix();
            gl.glTranslated(2.7+incX, 5.4, 0);
            gl.glScaled(0.04,0.04,0.04);
            gl.glColor3d(1, 0, 0);
            glut.glutSolidSphere(1 ,100 ,100);
            gl.glColor3d(1, 1, 1);
          gl.glPopMatrix();          
        gl.glPopMatrix();
        gl.glPushMatrix();
          gl.glPushMatrix();
            gl.glTranslated(2.775+incX, 5.4, 0);
            gl.glScaled(0.04,0.04,0.04);
            gl.glColor3d(1, 0, 0);
            glut.glutSolidSphere(1 ,100 ,100);
            gl.glColor3d(1, 1, 1);
          gl.glPopMatrix();          
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glColor3d(1, 0, 0);
        gl.glBegin(GL2.GL_TRIANGLES);
           gl.glVertex3d(2.65+incX, 5.4, 0);
           gl.glVertex3d(2.82+incX, 5.4, 0);
           gl.glVertex3d(2.7375+incX, 5.25, 0);
        gl.glEnd();
        gl.glPopMatrix();        
    }
    
    

    public double getPosZ() {
        return posZ;
    }

    public void setPosZ(double posZ) {
        this.posZ = posZ;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getIncX() {
        return incX;
    }

    public void setIncX(double incX) {
        this.incX = incX;
    }

    public double getVelZ() {
        return velZ;
    }

    public void setVelZ(double velZ) {
        this.velZ = velZ;
    }

    public void setR(double r) {
        this.r = r;
    }

    public void setG(double g) {
        this.g = g;
    }

    public void setB(double b) {
        this.b = b;
    }

    public int getValorAsteroide() {
        return valorAsteroide;
    }

    public void setValorAsteroide(int valorAsteroide) {
        this.valorAsteroide = valorAsteroide;
    }
    
    
}
