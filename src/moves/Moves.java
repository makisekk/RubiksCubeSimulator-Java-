package moves;
import java.lang.Thread;
import java.util.Random;
import javax.swing.JPanel;

//此类集中定义了所有能改变魔方状态的基本方法，包括打乱、回到打乱、重置、各种单步转动、无延时地执行公式、有延时地执行公式
public class Moves {
    public static int[][] color;                        //实时的魔方状态
    public static int[][] storeColor = new int[6][9];   //保存打乱后的魔方状态
    public static int temp;
    public static JPanel panel;

    //顶层顺时针旋转90°（正对顶层看）
    public static void U(){
               temp = color[0][0];
        color[0][0] = color[1][0];
        color[1][0] = color[2][0];
        color[2][0] = color[3][0];
        color[3][0] = temp;
               temp = color[0][1];
        color[0][1] = color[1][1];
        color[1][1] = color[2][1];
        color[2][1] = color[3][1];
        color[3][1] = temp;
               temp = color[0][2];
        color[0][2] = color[1][2];
        color[1][2] = color[2][2];
        color[2][2] = color[3][2];
        color[3][2] = temp;      
               temp = color[4][0];
        color[4][0] = color[4][6];
        color[4][6] = color[4][8];
        color[4][8] = color[4][2];
        color[4][2] = temp;
               temp = color[4][1];
        color[4][1] = color[4][3];
        color[4][3] = color[4][7];
        color[4][7] = color[4][5];
        color[4][5] = temp;
    }

    //顶层逆时针旋转90°（正对顶层看）
    public static void u(){
               temp = color[0][0];
        color[0][0] = color[3][0];
        color[3][0] = color[2][0];
        color[2][0] = color[1][0];
        color[1][0] = temp;
               temp = color[0][1];
        color[0][1] = color[3][1];
        color[3][1] = color[2][1];
        color[2][1] = color[1][1];
        color[1][1] = temp;
               temp = color[0][2];
        color[0][2] = color[3][2];
        color[3][2] = color[2][2];
        color[2][2] = color[1][2];
        color[1][2] = temp;      
               temp = color[4][0];
        color[4][0] = color[4][2];
        color[4][2] = color[4][8];
        color[4][8] = color[4][6];
        color[4][6] = temp;
               temp = color[4][1];
        color[4][1] = color[4][5];
        color[4][5] = color[4][7];
        color[4][7] = color[4][3];
        color[4][3] = temp;
    }
    
    //中间层旋转90°，方向同d
        public static void e(){
               temp = color[0][3];
        color[0][3] = color[1][3];
        color[1][3] = color[2][3];
        color[2][3] = color[3][3];
        color[3][3] = temp;
               temp = color[0][4];
        color[0][4] = color[1][4];
        color[1][4] = color[2][4];
        color[2][4] = color[3][4];
        color[3][4] = temp;
               temp = color[0][5];
        color[0][5] = color[1][5];
        color[1][5] = color[2][5];
        color[2][5] = color[3][5];
        color[3][5] = temp;      
    }

    //中间层旋转90°，方向同D
    public static void E(){
               temp = color[0][3];
        color[0][3] = color[3][3];
        color[3][3] = color[2][3];
        color[2][3] = color[1][3];
        color[1][3] = temp;
               temp = color[0][4];
        color[0][4] = color[3][4];
        color[3][4] = color[2][4];
        color[2][4] = color[1][4];
        color[1][4] = temp;
               temp = color[0][5];
        color[0][5] = color[3][5];
        color[3][5] = color[2][5];
        color[2][5] = color[1][5];
        color[1][5] = temp;      
    }

    //底层逆时针旋转90°（正对底层看）
    public static void d(){
               temp = color[0][6];
        color[0][6] = color[1][6];
        color[1][6] = color[2][6];
        color[2][6] = color[3][6];
        color[3][6] = temp;
               temp = color[0][7];
        color[0][7] = color[1][7];
        color[1][7] = color[2][7];
        color[2][7] = color[3][7];
        color[3][7] = temp;
               temp = color[0][8];
        color[0][8] = color[1][8];
        color[1][8] = color[2][8];
        color[2][8] = color[3][8];
        color[3][8] = temp;      
               temp = color[5][0];
        color[5][0] = color[5][6];
        color[5][6] = color[5][8];
        color[5][8] = color[5][2];
        color[5][2] = temp;
               temp = color[5][1];
        color[5][1] = color[5][3];
        color[5][3] = color[5][7];
        color[5][7] = color[5][5];
        color[5][5] = temp;
    }

    //底层顺时针旋转90°（正对底层看）
    public static void D(){
               temp = color[0][6];
        color[0][6] = color[3][6];
        color[3][6] = color[2][6];
        color[2][6] = color[1][6];
        color[1][6] = temp;
               temp = color[0][7];
        color[0][7] = color[3][7];
        color[3][7] = color[2][7];
        color[2][7] = color[1][7];
        color[1][7] = temp;
               temp = color[0][8];
        color[0][8] = color[3][8];
        color[3][8] = color[2][8];
        color[2][8] = color[1][8];
        color[1][8] = temp;      
               temp = color[5][0];
        color[5][0] = color[5][2];
        color[5][2] = color[5][8];
        color[5][8] = color[5][6];
        color[5][6] = temp;
               temp = color[5][1];
        color[5][1] = color[5][5];
        color[5][5] = color[5][7];
        color[5][7] = color[5][3];
        color[5][3] = temp;
    }
    
    //右层顺时针旋转90°（正对右层看）
    public static void R(){
               temp = color[0][2];
        color[0][2] = color[5][0];
        color[5][0] = color[2][6];
        color[2][6] = color[4][2];
        color[4][2] = temp;
               temp = color[0][5];
        color[0][5] = color[5][3];
        color[5][3] = color[2][3];
        color[2][3] = color[4][5];
        color[4][5] = temp;
               temp = color[0][8];
        color[0][8] = color[5][6];
        color[5][6] = color[2][0];
        color[2][0] = color[4][8];
        color[4][8] = temp; 
               temp = color[1][0];
        color[1][0] = color[1][6];
        color[1][6] = color[1][8];
        color[1][8] = color[1][2];
        color[1][2] = temp;
               temp = color[1][1];
        color[1][1] = color[1][3];
        color[1][3] = color[1][7];
        color[1][7] = color[1][5];
        color[1][5] = temp;
    }

    //右层逆时针旋转90°（正对右层看）
    public static void r(){
               temp = color[0][2];
        color[0][2] = color[4][2];
        color[4][2] = color[2][6];
        color[2][6] = color[5][0];
        color[5][0] = temp;
               temp = color[0][5];
        color[0][5] = color[4][5];
        color[4][5] = color[2][3];
        color[2][3] = color[5][3];
        color[5][3] = temp;
               temp = color[0][8];
        color[0][8] = color[4][8];
        color[4][8] = color[2][0];
        color[2][0] = color[5][6];
        color[5][6] = temp; 
               temp = color[1][0];
        color[1][0] = color[1][2];
        color[1][2] = color[1][8];
        color[1][8] = color[1][6];
        color[1][6] = temp;
               temp = color[1][1];
        color[1][1] = color[1][5];
        color[1][5] = color[1][7];
        color[1][7] = color[1][3];
        color[1][3] = temp;
    }
    
    //中间层旋转90°，方向同l
    public static void m(){
               temp = color[0][1];
        color[0][1] = color[5][1];
        color[5][1] = color[2][7];
        color[2][7] = color[4][1];
        color[4][1] = temp;
               temp = color[0][4];
        color[0][4] = color[5][4];
        color[5][4] = color[2][4];
        color[2][4] = color[4][4];
        color[4][4] = temp;
               temp = color[0][7];
        color[0][7] = color[5][7];
        color[5][7] = color[2][1];
        color[2][1] = color[4][7];
        color[4][7] = temp; 
    }

    //中间层旋转90°，方向同L
    public static void M(){
               temp = color[0][1];
        color[0][1] = color[4][1];
        color[4][1] = color[2][7];
        color[2][7] = color[5][1];
        color[5][1] = temp;
               temp = color[0][4];
        color[0][4] = color[4][4];
        color[4][4] = color[2][4];
        color[2][4] = color[5][4];
        color[5][4] = temp;
               temp = color[0][7];
        color[0][7] = color[4][7];
        color[4][7] = color[2][1];
        color[2][1] = color[5][7];
        color[5][7] = temp; 
    }

    //左层逆时针旋转90°（正对左层看）
    public static void l(){
               temp = color[0][0];
        color[0][0] = color[5][2];
        color[5][2] = color[2][8];
        color[2][8] = color[4][0];
        color[4][0] = temp;
               temp = color[0][3];
        color[0][3] = color[5][5];
        color[5][5] = color[2][5];
        color[2][5] = color[4][3];
        color[4][3] = temp;
               temp = color[0][6];
        color[0][6] = color[5][8];
        color[5][8] = color[2][2];
        color[2][2] = color[4][6];
        color[4][6] = temp; 
               temp = color[3][0];
        color[3][0] = color[3][2];
        color[3][2] = color[3][8];
        color[3][8] = color[3][6];
        color[3][6] = temp;
               temp = color[3][1];
        color[3][1] = color[3][5];
        color[3][5] = color[3][7];
        color[3][7] = color[3][3];
        color[3][3] = temp;
    }

    //左层顺时针旋转90°（正对左层看）
    public static void L(){
               temp = color[0][0];
        color[0][0] = color[4][0];
        color[4][0] = color[2][8];
        color[2][8] = color[5][2];
        color[5][2] = temp;
               temp = color[0][3];
        color[0][3] = color[4][3];
        color[4][3] = color[2][5];
        color[2][5] = color[5][5];
        color[5][5] = temp;
               temp = color[0][6];
        color[0][6] = color[4][6];
        color[4][6] = color[2][2];
        color[2][2] = color[5][8];
        color[5][8] = temp; 
               temp = color[3][0];
        color[3][0] = color[3][6];
        color[3][6] = color[3][8];
        color[3][8] = color[3][2];
        color[3][2] = temp;
               temp = color[3][1];
        color[3][1] = color[3][3];
        color[3][3] = color[3][7];
        color[3][7] = color[3][5];
        color[3][5] = temp;
    }

    //前层顺时针旋转90°（正对前层看）
    public static void F(){
               temp = color[1][0];
        color[1][0] = color[4][6];
        color[4][6] = color[3][8];
        color[3][8] = color[5][0];
        color[5][0] = temp;
               temp = color[1][3];
        color[1][3] = color[4][7];
        color[4][7] = color[3][5];
        color[3][5] = color[5][1];
        color[5][1] = temp;
               temp = color[1][6];
        color[1][6] = color[4][8];
        color[4][8] = color[3][2];
        color[3][2] = color[5][2];
        color[5][2] = temp; 
               temp = color[0][0];
        color[0][0] = color[0][6];
        color[0][6] = color[0][8];
        color[0][8] = color[0][2];
        color[0][2] = temp;
               temp = color[0][1];
        color[0][1] = color[0][3];
        color[0][3] = color[0][7];
        color[0][7] = color[0][5];
        color[0][5] = temp;
    }

    //前层逆时针旋转90°（正对前层看）
    public static void f(){
               temp = color[1][0];
        color[1][0] = color[5][0];
        color[5][0] = color[3][8];
        color[3][8] = color[4][6];
        color[4][6] = temp;
               temp = color[1][3];
        color[1][3] = color[5][1];
        color[5][1] = color[3][5];
        color[3][5] = color[4][7];
        color[4][7] = temp;
               temp = color[1][6];
        color[1][6] = color[5][2];
        color[5][2] = color[3][2];
        color[3][2] = color[4][8];
        color[4][8] = temp; 
               temp = color[0][0];
        color[0][0] = color[0][2];
        color[0][2] = color[0][8];
        color[0][8] = color[0][6];
        color[0][6] = temp;
               temp = color[0][1];
        color[0][1] = color[0][5];
        color[0][5] = color[0][7];
        color[0][7] = color[0][3];
        color[0][3] = temp;
    }

    //中间层旋转90°，方向同F
    public static void S(){
               temp = color[1][1];
        color[1][1] = color[4][3];
        color[4][3] = color[3][7];
        color[3][7] = color[5][3];
        color[5][3] = temp;
               temp = color[1][4];
        color[1][4] = color[4][4];
        color[4][4] = color[3][4];
        color[3][4] = color[5][4];
        color[5][4] = temp;
               temp = color[1][7];
        color[1][7] = color[4][5];
        color[4][5] = color[3][1];
        color[3][1] = color[5][5];
        color[5][5] = temp; 
    }

    //中间层旋转90°，方向同f
    public static void s(){
               temp = color[1][1];
        color[1][1] = color[5][3];
        color[5][3] = color[3][7];
        color[3][7] = color[4][3];
        color[4][3] = temp;
               temp = color[1][4];
        color[1][4] = color[5][4];
        color[5][4] = color[3][4];
        color[3][4] = color[4][4];
        color[4][4] = temp;
               temp = color[1][7];
        color[1][7] = color[5][5];
        color[5][5] = color[3][1];
        color[3][1] = color[4][5];
        color[4][5] = temp;
    }

    //后层逆时针旋转90°（正对后层看）
    public static void b(){
               temp = color[1][2];
        color[1][2] = color[4][0];
        color[4][0] = color[3][6];
        color[3][6] = color[5][6];
        color[5][6] = temp;
               temp = color[1][5];
        color[1][5] = color[4][1];
        color[4][1] = color[3][3];
        color[3][3] = color[5][7];
        color[5][7] = temp;
               temp = color[1][8];
        color[1][8] = color[4][2];
        color[4][2] = color[3][0];
        color[3][0] = color[5][8];
        color[5][8] = temp; 
               temp = color[2][0];
        color[2][0] = color[2][2];
        color[2][2] = color[2][8];
        color[2][8] = color[2][6];
        color[2][6] = temp;
               temp = color[2][1];
        color[2][1] = color[2][5];
        color[2][5] = color[2][7];
        color[2][7] = color[2][3];
        color[2][3] = temp;
    }

    //后层顺时针旋转90°（正对后层看）
    public static void B(){
               temp = color[1][2];
        color[1][2] = color[5][6];
        color[5][6] = color[3][6];
        color[3][6] = color[4][0];
        color[4][0] = temp;
               temp = color[1][5];
        color[1][5] = color[5][7];
        color[5][7] = color[3][3];
        color[3][3] = color[4][1];
        color[4][1] = temp;
               temp = color[1][8];
        color[1][8] = color[5][8];
        color[5][8] = color[3][0];
        color[3][0] = color[4][2];
        color[4][2] = temp; 
               temp = color[2][0];
        color[2][0] = color[2][6];
        color[2][6] = color[2][8];
        color[2][8] = color[2][2];
        color[2][2] = temp;
               temp = color[2][1];
        color[2][1] = color[2][3];
        color[2][3] = color[2][7];
        color[2][7] = color[2][5];
        color[2][5] = temp;
    }

    //同时转动两层
    public static void p(){
       perform("e d");
    }
    public static void P(){
       perform("E D");
    }

    //整体转动90°，方向同U
    public static void X(){
       perform("U e d");
    }

    //整体转动90°，方向同u
    public static void x(){
       perform("u E D");
    }

    //整体转动90°，方向同R
    public static void Y(){
       perform("R m l");
    }

    //整体转动90°，方向同r
    public static void y(){
       perform("r M L");
    }

    //执行字符串公式，如“RUruslm”，可以用空格隔开
    public static void perform(String str){
      char[] formula = str.toCharArray();
      for(int i=0;i<formula.length;i+=1){
          if(formula[i] == ' ')continue;
          switch(formula[i]){  
               case 'R':{
                  R();
                  break;
               }    
               case 'U':{
                  U();
                  break;
               }
               case 'r':{
                   r();
                   break;
               }    
               case 'u':{
                   u();
                   break;
               }
               case 'L':{
                   L();
                   break;
               }    
               case 'l':{
                   l();
                   break;
               }
               case 'd':{
                   d();
                   break;
               }    
               case 'D':{
                   D();
                   break;
               }
               case 'E':{
                   E();
                   break;
               }    
               case 'e':{
                   e();
                   break;
               }
               case 'F':{
                   F();
                   break;
               }    
               case 'f':{
                   f();
                   break;
               }
               case 'B':{
                   B();
                   break;
               }    
               case 'b':{
                   b();
                   break;
               }
               case 'm':{
                   m();
                   break;
               }
               case 'M':{
                   M();
                   break;
               }    
               case 's':{
                   s();
                   break;
               }
               case 'S':{
                   S();
                   break;
               }
               case 'P':{
                   P();
                   break;   
               }
               case 'p':{
                   p();
                   break;   
               }   
               case 'X':{
                   X(); 
                   break;
               }    
               case 'x':{
                   x();
                   break;
               }
               case 'Y':{
                   Y();
                   break;
               }    
               case 'y':{
                   y();
                   break;
               }
              
               default: {
                  System.out.println("Invalid Input");
               }
          }   
      }
   }

   //有延时地执行字符串公式，用于需要展示转动过程的场合
   public static void perform(String str,long delay){
       char[] formula = str.toCharArray();
       for(int i=0;i<formula.length;i+=1){
           if(formula[i] == ' ')
              continue;
           try{ 
              panel.repaint();  
              Thread.sleep(delay);
              panel.repaint(); 
           }
           catch(Exception e){;}  
           switch(formula[i]){  
                case 'R':{
                   R();
                   break;
                }    
                case 'U':{
                   U();
                   break;
                }
                case 'r':{
                    r();
                    break;
                }    
                case 'u':{
                    u();
                    break;
                }
                case 'L':{
                    L();
                    break;
                }    
                case 'l':{
                    l();
                    break;
                }
                case 'd':{
                    d();
                    break;
                }    
                case 'D':{
                    D();
                    break;
                }
                case 'E':{
                    E();
                    break;
                }    
                case 'e':{
                    e();
                    break;
                }
                case 'F':{
                    F();
                    break;
                }    
                case 'f':{
                    f();
                    break;
                }
                case 'B':{
                    B();
                    break;
                }    
                case 'b':{
                    b();
                    break;
                }
                case 'm':{
                    m();
                    break;
                }
                case 'M':{
                    M();
                    break;
                }    
                case 's':{
                    s();
                    break;
                }
                case 'S':{
                    S();
                    break;
                }
                case 'P':{
                     P();
                     break;   
                }
                case 'p':{
                     p();
                     break;   
                }
                
                //X,x,Y,y是对魔方整体的转动，适当加长延时有助于用户看清空间关系
                case 'X':{
                    X();
                    try{   
                       Thread.sleep(1000);
                       panel.repaint(); 
                    }
                    catch(Exception e){
                       ;
                    }
                    break;
                }    
                case 'x':{
                    x();
                    try{   
                       Thread.sleep(1000);
                       panel.repaint(); 
                    }
                    catch(Exception e){
                       ;
                    }
                    break;
                }
                case 'Y':{
                    Y();
                    try{   
                       Thread.sleep(1000);
                       panel.repaint(); 
                    }
                    catch(Exception e){
                       ;
                    }
                    break;
                }    
                case 'y':{
                    y();
                    try{   
                       Thread.sleep(1000);
                       panel.repaint(); 
                    }
                    catch(Exception e){
                       ;
                    }
                    break;
                }
               
                default: {
                   System.out.println("Invalid Input");
                }
              
           }    
       }
    }   

    //回到未打乱状态的方法
    public static void reset(){           
       for(int i=0;i<6;i+=1){
              for(int j=0;j<9;j+=1){
                     color[i][j] = i;
              }
       }
    }

    //随机生成打乱公式并从复原的魔方开始打乱的方法
    public static String reshuffle(){
       reset();    
       Random rand = new Random();    
       String formula = new String("");
       int temp;

       //将转动按转动方向分为两两垂直的三组，穿插着生成打乱公式，增强打乱效果
       String[] set1 = {"U","u","E","e","D","d"};
       String[] set2 = {"F","f","S","s","B","b"};
       String[] set3 = {"L","l","M","m","R","r"};    
       for(int i=0;i<6;i+=1){
              formula += set1[rand.nextInt(6)];
              formula += set2[rand.nextInt(6)];
              formula += set3[rand.nextInt(6)];
       }
       for(int i=0;i<2;i+=1){
              temp = rand.nextInt(6);
              formula = formula + set1[temp] +set1[temp];
              temp = rand.nextInt(6);
              formula = formula + set2[temp] +set2[temp];
              temp = rand.nextInt(6);
              formula = formula + set3[temp] +set3[temp];
       }
       //打乱魔方
       perform(formula,100);
       //保存打乱后的魔方状态
       for(int i=0;i<6;i+=1)
              for(int j=0;j<9;j+=1)
                     storeColor[i][j] = color[i][j];

       return formula;
    }

    //此方法读取打乱后的魔方状态
    public static void load_reshuffle(){
       for(int i=0;i<6;i+=1)
              for(int j=0;j<9;j+=1)
                     color[i][j] = storeColor[i][j];    
    }
}
