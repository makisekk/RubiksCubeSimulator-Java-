package solutions;
import javax.swing.*;
import moves.Moves;

//还原顶层块朝向，“朝向正确”指顶层角块、顶层棱块的黄色面位于顶面
public class OrientationOfLastLayer extends Solution{

    public OrientationOfLastLayer(JPanel panel,int[][] color){
        super(panel,color);
    }

    public void run(){
        direct();
        //检查前序步骤是否完成，若未完成不执行还原，并弹出提醒消息
        if(  color[5][1]!=BLACK || color[5][3]!=BLACK || color[5][5]!=BLACK || color[5][7]!=BLACK  ||
             color[5][0]!=BLACK || color[5][2]!=BLACK || color[5][6]!=BLACK || color[5][8]!=BLACK  ||
             color[0][7]!=BLUE  || color[1][7]!=RED   || color[2][7]!=GREEN || color[3][7]!=ORANGE ||
             color[0][3]!=BLUE  || color[1][3]!=RED   || color[2][3]!=GREEN || color[3][3]!=ORANGE ||
             color[0][5]!=BLUE  || color[1][5]!=RED   || color[2][5]!=GREEN || color[3][5]!=ORANGE ||
             color[0][6]!=BLUE  || color[1][6]!=RED   || color[2][6]!=GREEN || color[3][6]!=ORANGE ||
             color[0][8]!=BLUE  || color[1][8]!=RED   || color[2][8]!=GREEN || color[3][8]!=ORANGE){
            JOptionPane.showMessageDialog(panel, "请先还原黑色底的前两层哦！", "您跳步了",JOptionPane.WARNING_MESSAGE); 
        }
        else{

            //判断顶层四棱块的状态
            //对应图示请参考设计文档
            state = 0;
            for(int i=0;i<4;i+=1){
                if(color[4][1]==YELLOW && color[4][3]==YELLOW && color[4][5]==YELLOW && color[4][7]==YELLOW){
                    state = 4;
                }    
                else if(color[4][1]!=YELLOW && color[4][3]!=YELLOW && color[4][5]!=YELLOW && color[4][7]!=YELLOW){
                    state = 1;
                }    
                else if(color[4][3]==YELLOW && color[4][5]==YELLOW){
                    state = 2;
                }     
                else if(color[4][1]==YELLOW && color[4][3]==YELLOW){
                    state = 3;
                }    
                //若皆不匹配，顶层旋转90°重新匹配
                if(state==0)
                    Moves.perform("U",delay);
                else 
                    break;
            }
            stall(200+delay);
            //还原顶层四棱块朝向
            switch(state){
                case 4:break;
                case 1:{
                    Moves.perform("F U R u r f", delay);
                    stall(2*delay);
                    Moves.perform("U F R U r u f",delay);
                    break;
                }
                case 2:{
                    Moves.perform("F R U r u f",delay);
                    break;
                }
                case 3:{
                    Moves.perform("F U R u r f",delay);
                    break;
                }
                default:System.out.println("Error in OLL method 'run'.");
            }

            //判断顶层四角块的状态
            //对应图示请参考设计文档
            state = 0;  
            for(int i=0;i<4;i+=1){
                if(color[4][0]==YELLOW && color[4][2]==YELLOW && color[4][6]==YELLOW){
                    state = 8;
                }         
                else if(color[0][0]==YELLOW && color[1][0]==YELLOW && color[2][0]==YELLOW){
                    state = 1;
                }    
                else if(color[0][2]==YELLOW && color[1][2]==YELLOW && color[2][2]==YELLOW){
                    state = 2;
                }    
                else if(color[0][0]==YELLOW && color[4][2]==YELLOW && color[4][8]==YELLOW){
                    state = 3;
                }                                      
                else if(color[2][0]==YELLOW && color[4][6]==YELLOW && color[4][8]==YELLOW){
                    state = 4;
                }    
                else if(color[0][2]==YELLOW && color[4][2]==YELLOW && color[4][6]==YELLOW){
                    state = 5;
                }     
                else if(color[0][2]==YELLOW && color[3][0]==YELLOW && color[3][2]==YELLOW){
                    state = 6;
                }     
                else if(color[0][0]==YELLOW && color[0][2]==YELLOW && color[2][0]==YELLOW){
                    state = 7;
                }    
                //若皆不匹配，顶层旋转90°重新匹配  
                if(state==0)
                    Moves.perform("U",delay);
                else 
                    break;
            }
            stall(200+delay);
                //还原顶层四角块朝向
                switch(state){
                case 8:break;
                case 1:{
                    Moves.perform("r u R u r u u R", delay);
                    break;
                }
                case 2:{
                    Moves.perform("R U r U R U U r",delay);
                    break;
                }
                case 3:{
                    Moves.perform("m R U r u M r F R f",delay);
                    break;
                }
                case 4:{
                    Moves.perform("r r d R U U r D R U U R", delay);
                    break;
                }
                case 5:{
                    Moves.perform("f m R U r u M r F R",delay);
                    break;
                }
                case 6:{
                    Moves.perform("R U U R R u R R u R R u u R",delay);
                    break;
                }
                case 7:{
                    Moves.perform("R U U r u R U r u R u r", delay);
                    break;
                }
                default:System.out.println("Error in OLL method 'run'.");
            }
            stall(300+delay);
        }    
    }
}
