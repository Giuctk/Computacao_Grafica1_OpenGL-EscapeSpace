/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto_EscapeSpace_130854;

import com.jogamp.opengl.util.gl2.GLUT;
import java.util.ArrayList;
import java.util.Random;
import javax.media.opengl.GL2;

/**
 *
 * @author Giuliano Cesari Tacioli_130854
 */
public class Jogo {

    private int tempoEspera = 0, nivel = 1, vidas = 3, Pontos = 0;
    private boolean fimDeJogo = false, venceu = false;
    private double velCriaAsteroide = 0, velMoveAsteroide = 0, velFeixe = 0, incX = 0;
    private ArrayList<Objeto> objetos = new ArrayList<>();
    private ArrayList<Objeto> vidaArray = new ArrayList<>();
    private ArrayList<Feixe_Luz> feixesArray = new ArrayList<>();
    private Planetas planeta = new Planetas();
    private Background background = new Background();
    private Feixe_Luz feixeLuz = new Feixe_Luz();
    ArrayList<Feixe_Luz> resetaArray = new ArrayList<>();

    public Jogo() {
        objetos.add(new Objeto());
    }

    public void criaObjetos(GLUT glut, GL2 gl) {
        objetos.get(0).desenhaPlayer(glut, gl);
        verificaPontos();
        verificaNivel();
        verificaVida();
        criaFeixe(glut, gl);
        desenhaFeixes(glut, gl);
        desenhaVidas(glut, gl);
        criaAsteroides(glut, gl);
        desenhaAsteroides(glut, gl);
        limpaArrayFeixe();
        limpaArrayAsteroide();
        verificaColisao();
    }
    
    public void verificaPontos(){
        if(Pontos >= 0 && Pontos <= 30)
            nivel = 1;
        else if(Pontos >= 31 && Pontos <= 60)
            nivel = 2;
        else if(Pontos >= 61 && Pontos <= 120)
            nivel = 3;
        else if(Pontos >= 121 && Pontos <= 250)
            nivel = 4;
        else if(Pontos >= 251 && Pontos <= 500)
            nivel = 5;
        else if(Pontos >= 501 && Pontos <= 1000)
            nivel = 6;
        else if(Pontos >= 1001)
            venceu = true;
        
    }
    
    public void verificaVida(){
        if(vidas <1)
            fimDeJogo = true;    
    }
    
    public void desenhaVidas(GLUT glut, GL2 gl){
        vidaArray.clear();
        for(int i = 0 ; i < vidas ; i++){
            Objeto vida = new Objeto();
            vida.setIncX(incX);
            vidaArray.add(vida);
            incX += 0.23;
        }
        incX = 0;
        for(int i = 0 ; i < vidaArray.size() ; i++){
            vidaArray.get(i).desenhaVidas(glut, gl);
        }
    }
    
    
    public void verificaColisao(){
        for(int i = 0; i < objetos.size(); i++){
            if(i > 0){
               if(objetos.get(i).getPosZ()-40 >= objetos.get(0).getPosZ()-1 && objetos.get(i).getPosZ()-40 <= objetos.get(0).getPosZ()+1 &&
                  objetos.get(i).getPosY()== objetos.get(0).getPosY() && objetos.get(i).getPosX()== objetos.get(0).getPosX()){
                   vidas --;
                   objetos.remove(objetos.get(i));
               }     
            }
        }
    }
    
    public void verificaNivel(){
        switch (nivel) {
            case 1:                
                velCriaAsteroide = 20;
                velMoveAsteroide = 0.5;              
                velFeixe = 0.5;
                break;
            case 2:
                velCriaAsteroide = 15;
                velMoveAsteroide = 0.8;
                velFeixe = 1;
                break;
            case 3:
                velCriaAsteroide = 10;
                velMoveAsteroide = 1.1;
                velFeixe = 1.5;
                break;
            case 4:
                velCriaAsteroide = 6;
                velMoveAsteroide = 1.4;
                velFeixe = 2;
                break;
            case 5:
                velCriaAsteroide = 3;
                velMoveAsteroide = 1.8;
                velFeixe = 4;
                break;
            case 6:
                velCriaAsteroide = 2;
                velMoveAsteroide = 2.4;
                velFeixe = 6;
                break;
        }   
    }
    
    public void limpaArrayFeixe(){
        ArrayList<Feixe_Luz> limpaFeixe = new ArrayList<Feixe_Luz>();
        for(int i = 1; i < feixesArray.size(); i++){
            if(i > 1){
                if(feixesArray.get(i).getZ()-10 > 5){
                    limpaFeixe.add(feixesArray.get(i));
                }
            }
        }
        feixesArray.removeAll(limpaFeixe);
    }
    
    public void limpaArrayAsteroide(){
        ArrayList<Objeto> limpa = new ArrayList<>();
        for(int i = 1; i < objetos.size(); i++){
            if(i > 1){
                if(objetos.get(i).getPosZ()-40 > 5){
                    limpa.add(objetos.get(i));
                    Pontos += objetos.get(i).getValorAsteroide();
                }
            }
        }
        objetos.removeAll(limpa);
    }
    
    public void desenhaAsteroides(GLUT glut, GL2 gl){
        for(int i = 0; i < objetos.size(); i++){
            if(i > 0){
                objetos.get(i).desenhaAsteroide(glut, gl);
                objetos.get(i).setPosZ(objetos.get(i).getPosZ() + velMoveAsteroide);
                objetos.get(i).setVelZ(objetos.get(i).getVelZ() + 25);
            }
        }
    }
    
    
    public void criaAsteroides(GLUT glut, GL2 gl){
        if(tempoEspera < velCriaAsteroide){
            tempoEspera ++;
        }
        else if(tempoEspera >= velCriaAsteroide){
            Objeto asteroide = new Objeto();
            asteroide.setPosX(randomXasteroide());
            asteroide.setPosY(randomYasteroide());
            randomColor(asteroide);
            objetos.add(asteroide);
            tempoEspera = 0;
        }
    }
    
    public void randomColor(Objeto asteroide){
        Random ra = new Random();
        int r = ra.nextInt(5);
        if(r == 0){
            asteroide.setR(0.02);
            asteroide.setG(0.02);
            asteroide.setB(0.02);
            asteroide.setValorAsteroide(10);
        }
        else if(r == 1){
            asteroide.setR(0.1);
            asteroide.setG(0.1);
            asteroide.setB(0.1);
            asteroide.setValorAsteroide(7);
        }
        else if(r == 2){
            asteroide.setR(0.2);
            asteroide.setG(0.2);
            asteroide.setB(0.2);
            asteroide.setValorAsteroide(5);
        }
        else if(r == 3){
            asteroide.setR(0.3);
            asteroide.setG(0.3);
            asteroide.setB(0.3);
            asteroide.setValorAsteroide(3);
        }
        else if(r == 4){
            asteroide.setR(0.4);
            asteroide.setG(0.4);
            asteroide.setB(0.4);
            asteroide.setValorAsteroide(1);
        }
    }
    
    public void desenhasPlanetas(GLUT glut, GL2 gl){
        planeta.desenhar(glut, gl);
        feixesArray.add(new Feixe_Luz());        
    }
    
    public void criaFeixe(GLUT glut, GL2 gl){        
        if(feixesArray.size() < 100){
            Feixe_Luz feixe = new Feixe_Luz();
            feixe.setX(randomXFeixe());
            feixe.setY(randomYFeixe());
            feixesArray.add(feixe);
        }
    }
    
    public void desenhaFeixes(GLUT glut, GL2 gl){
        for(int i = 0; i < feixesArray.size(); i++){
            if(i > 0){
                feixesArray.get(i).desenhaFeixeLuz(glut, gl);
                feixesArray.get(i).setZ((feixesArray.get(i).getZ() + velFeixe));
            }
        }
    }
    public double randomXasteroide(){
        Random r = new Random();
        int b = r.nextInt(2);
        switch(b){
            case 0:
                return -2.2;
            case 1:
                return 2.2;
        }
        return 0;
    }
    
    public double randomYasteroide(){
        Random r = new Random();
        int b = r.nextInt(2);
        switch(b){
            case 0:
                return 0;
            case 1:
                return 4.5;
        }
        return 0;
    }
    
    public double randomXFeixe(){
        Random r = new Random();
        double valX = r.nextInt(7);
        int r2 = r.nextInt(2);
        switch(r2){
            case 0:
                return valX;
            case 1:
                return valX * -1;
        }
        return 0;
    }
    
    public double randomYFeixe(){
        Random r = new Random();
        return r.nextInt(8);
    }
    
    public void configurarTeclas(boolean right, boolean left, boolean up, boolean down){
        PosicaoPlayer(right, left, up, down);        
    }
    
    public void criaFundo(GLUT glut, GL2 gl){
        background.desenhaBackground(glut, gl);
    } 
    
    public void PosicaoPlayer(boolean right, boolean left, boolean up, boolean down){
        if(right){
            if(objetos.get(0).getPosX() == -2.2)
                objetos.get(0).setPosX(2.2);            
            
        }
        
        if(left){
            if(objetos.get(0).getPosX() == 2.2)
                objetos.get(0).setPosX(-2.2);
            
        }
        if(up){
            if(objetos.get(0).getPosY()== 0)
                objetos.get(0).setPosY(4.5);
            
        }
        if(down){
            if(objetos.get(0).getPosY()== 4.5)
                objetos.get(0).setPosY(0);
            
        }
        
    }

    public boolean getFimDeJogo() {
        return fimDeJogo;
    }

    public void setfimDeJogo(boolean fimDeJogo) {
        this.fimDeJogo = fimDeJogo;
    }

    public int getPontos() {
        return Pontos;
    }

    public int getNivel() {
        return nivel;
    }

    public boolean isVenceu() {
        return venceu;
    }

    public void setVenceu(boolean venceu) {
        this.venceu = venceu;
    }
    
    
}
