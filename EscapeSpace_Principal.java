/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_EscapeSpace_130854;

import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.gl2.GLUT;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLJPanel;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;

/**
 *
 * @author Giuliano Cesari Tacioli_130854
 */
public class EscapeSpace_Principal
        implements GLEventListener, KeyListener {

    static GLU glu = new GLU();
    static GLUT glut = new GLUT();
    boolean right, left, up, down, start, menu = true;
    int count = 25;

    public static void main(String args[]) {
        new EscapeSpace_Principal();
    }

    public EscapeSpace_Principal() {
        GLJPanel canvas = new GLJPanel();
        canvas.addGLEventListener(this);
        

        JFrame frame = new JFrame("Escape Space");
        frame.setSize(900, 700);
        frame.getContentPane().add(canvas);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new Thread(new Runnable() {
                    public void run() {
                        System.exit(0);
                    }
                }).start();
            }
        });

        frame.addKeyListener(this);

    }

    public void init(GLAutoDrawable glAuto) {
        Animator a = new Animator(glAuto);
        a.start();
    }

    Jogo jogo = new Jogo();

    @Override
    public void display(GLAutoDrawable glAuto) {

        GL2 gl = glAuto.getGL().getGL2();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT
                | GL.GL_DEPTH_BUFFER_BIT);

        gl.glLoadIdentity();
        gl.glTranslated(0, -2.5, -6);
        
        
        if (jogo.getFimDeJogo()) {
            if (!start) {
                gl.glRasterPos3d(-1, 4.4, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "Parou no nivel: " + jogo.getNivel());
                gl.glRasterPos3d(-1, 4, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "Pontuação: " + jogo.getPontos());
                gl.glRasterPos3d(-1, 3.3, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "Pressione Q para jogar novamente!");
            }
            else if(start){
                jogo = new Jogo();
            }
        }
        
        if (!jogo.getFimDeJogo()) {                        
            
            if(menu){
                gl.glRasterPos3d(-0.8, 5.5, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "*ESCAPE SPACE*");
                
                gl.glRasterPos3d(-3, 4.8, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "MOVIMENTAÇÃO ");
                gl.glRasterPos3d(-3, 4.4, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "Cima:  W / UP: ");
                gl.glRasterPos3d(-3, 4.1, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "Baixo:  S / DOWN");
                gl.glRasterPos3d(-3, 3.8, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "Esquerda:  A / LEFT");
                gl.glRasterPos3d(-3, 3.5, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "Direita:  D / RIGHT");
                      
                gl.glRasterPos3d(-3, 2.8, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "Pontos");
                gl.glRasterPos3d(-1.8, 2.8, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "Nivel");
                gl.glRasterPos3d(-3, 2.4, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "0 ~ 30");
                gl.glRasterPos3d(-1.8, 2.4, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "1");
                gl.glRasterPos3d(-3, 2.1, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "31 ~ 60");
                gl.glRasterPos3d(-1.8, 2.1, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "2");
                gl.glRasterPos3d(-3, 1.8, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "61 ~ 120");
                gl.glRasterPos3d(-1.8, 1.8, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "3");
                gl.glRasterPos3d(-3, 1.5, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "121 ~ 250");
                gl.glRasterPos3d(-1.8, 1.5, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "4");
                gl.glRasterPos3d(-3, 1.2, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "251 ~ 500");
                gl.glRasterPos3d(-1.8, 1.2, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "5");
                gl.glRasterPos3d(-3, 0.9, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "501 ~ 1000");
                gl.glRasterPos3d(-1.8, 0.9, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "6");
                
                gl.glRasterPos3d(0, 4.8, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "Em Escape Space o objetivo é desviar dos");
                gl.glRasterPos3d(0, 4.5, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "asteroides vindo em sua direção.");
                gl.glRasterPos3d(0, 4.2, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "Cada asteroide que passar por você lhe dará");
                gl.glRasterPos3d(0, 3.9, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "pontos. Os pontos são determinados pela cor");
                gl.glRasterPos3d(0, 3.6, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "do asteroide, sendo que a cor mais escuro lhe");
                gl.glRasterPos3d(0, 3.3, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "dará mais pontos, pela maior dificuldade de");
                gl.glRasterPos3d(0, 3.0, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "enxergar o asteroide");
              
                gl.glRasterPos3d(-1.5, 0, 0);
                glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "Pressione ESPAÇO para Iniciar o Jogo!");
            }
            else {
            jogo.criaObjetos(glut, gl);
            jogo.desenhasPlanetas(glut, gl);
            jogo.configurarTeclas(right, left, up, down);
            jogo.criaFundo(glut, gl);
            gl.glRasterPos3d(2.3, 5.7, 0);
            glut.glutBitmapString(GLUT.BITMAP_HELVETICA_10, "Nivel = " + jogo.getNivel());
            gl.glRasterPos3d(2.3, 5.5, 0);
            glut.glutBitmapString(GLUT.BITMAP_HELVETICA_10, "Score = " + jogo.getPontos());
            gl.glRasterPos3d(2.3, 5.3, 0);
            glut.glutBitmapString(GLUT.BITMAP_HELVETICA_10, "Vidas = ");
            }
        }
    }

    public void reshape(GLAutoDrawable gLAutoDrawable, int x, int y, int w, int h) {
        GL2 gl = gLAutoDrawable.getGL().getGL2();
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(60, 1, 1, 30);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
        gl.glTranslated(0, 0, -5);
        gl.glEnable(GL2.GL_DEPTH_TEST);
    }

    public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {

    }

    public void dispose(GLAutoDrawable glad) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_D) {
            right = true;
        }
        if (ke.getKeyCode() == KeyEvent.VK_A) {
            left = true;
        }
        if (ke.getKeyCode() == KeyEvent.VK_W) {
            up = true;
        }
        if (ke.getKeyCode() == KeyEvent.VK_S) {
            down = true;
        }
        
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = true;
        }
        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            left = true;
        }
        if (ke.getKeyCode() == KeyEvent.VK_UP) {
            up = true;
        }
        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
            down = true;
        }
        
        if (ke.getKeyCode() == KeyEvent.VK_Q) {
            start = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_D) {
            right = false;
        }
        if (ke.getKeyCode() == KeyEvent.VK_A) {
            left = false;
        }
        if (ke.getKeyCode() == KeyEvent.VK_W) {
            up = false;
        }
        if (ke.getKeyCode() == KeyEvent.VK_S) {
            down = false;
        }
        
        
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = false;
        }
        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            left = false;
        }
        if (ke.getKeyCode() == KeyEvent.VK_UP) {
            up = false;
        }
        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
            down = false;
        }
        
        if (ke.getKeyCode() == KeyEvent.VK_Q) {
            start = false;
        }
        
        if (ke.getKeyCode() == KeyEvent.VK_SPACE) {
            menu = false;
            jogo.setVenceu(false);
        }

    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }
}
