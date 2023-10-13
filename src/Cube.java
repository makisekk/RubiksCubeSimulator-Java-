import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import moves.Moves;
import solutions.*;
import java.lang.Thread;

public class Cube {
        public static final int BLUE   = 0; //常量定义
        public static final int RED    = 1;
        public static final int GREEN  = 2;
        public static final int ORANGE = 3;
        public static final int YELLOW = 4;
        public static final int BLACK  = 5;

        //指定RGB值调制需要用到的颜色
        public static Color lightblue = new Color(0,255,255);
        public static Color backgroundColor = new Color(135,38,87);

        //记录魔方状态，如cubeColor[0][0]保存A0面的颜色，cubeColor[5][8]保存F8面的颜色；初始化为魔方未被打乱的状态
        public static int[][] cubeColor =  {{BLUE   ,BLUE   ,BLUE   ,BLUE   ,BLUE   ,BLUE   ,BLUE   ,BLUE   ,BLUE  },
                                            {RED    ,RED    ,RED    ,RED    ,RED    ,RED    ,RED    ,RED    ,RED   },
                                            {GREEN  ,GREEN  ,GREEN  ,GREEN  ,GREEN  ,GREEN  ,GREEN  ,GREEN  ,GREEN },
                                            {ORANGE ,ORANGE ,ORANGE ,ORANGE ,ORANGE ,ORANGE ,ORANGE ,ORANGE ,ORANGE},
                                            {YELLOW ,YELLOW ,YELLOW ,YELLOW ,YELLOW ,YELLOW ,YELLOW ,YELLOW ,YELLOW},
                                            {BLACK  ,BLACK  ,BLACK  ,BLACK  ,BLACK  ,BLACK  ,BLACK  ,BLACK  ,BLACK }};
    
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("三阶魔方模拟器");
        MyPanel panel = new MyPanel();
        Cross cross = new Cross(panel,cubeColor);
        First2Layers f2l = new First2Layers(panel,cubeColor);
        OrientationOfLastLayer oll = new OrientationOfLastLayer(panel,cubeColor);
        PermutationOfLastLayer pll = new PermutationOfLastLayer(panel,cubeColor);

        //设置窗口
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600,800);      
        
        //设置菜单栏
        JMenuBar menuBar = new JMenuBar();
        //用于设置自动复原速度的一级菜单,选择不同的子菜单将改变延时的基础值
        //“很快”为50ms，“快”为200ms，“慢”为600ms，“很慢”为1200ms
        JMenu speedMenu = new JMenu("复原速度");            
        JMenuItem veryFastMenuItem = new JMenuItem("很快");
        JMenuItem fastMenuItem = new JMenuItem("快");
        JMenuItem slowMenuItem = new JMenuItem("慢");
        JMenuItem verySlowMenuItem = new JMenuItem("很慢");
        veryFastMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                cross.delay = 50;
                f2l.delay = 50;
                oll.delay = 50;
                pll.delay = 50;
            }
        });
        fastMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                cross.delay = 200;
                f2l.delay = 200;
                oll.delay = 200;
                pll.delay = 200;
            }
        });
        slowMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                cross.delay = 600;
                f2l.delay = 600;
                oll.delay = 600;
                pll.delay = 600;
            }
        });
        verySlowMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                cross.delay = 1200;
                f2l.delay = 1200;
                oll.delay = 1200;
                pll.delay = 1200;
            }
        });
        speedMenu.add(veryFastMenuItem);
        speedMenu.add(fastMenuItem);
        speedMenu.add(slowMenuItem);
        speedMenu.add(verySlowMenuItem);
        menuBar.add(speedMenu);
        frame.setJMenuBar(menuBar);

        //所有组件均用绝对坐标定位
        panel.setLayout(null);

        panel.setBackground(backgroundColor);
        frame.getContentPane().add(panel);

        //定义所有30个按钮以及监听器
        JButton[] buttons = new JButton[30];

        JButton b1 = new JButton("U");
        b1.setBounds(440, 305, 50, 70);
        b1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Moves.U();
                    panel.repaint();
                }
            }
        );
        panel.add(b1);

        JButton b2 = new JButton("u");
        b2.setBounds(840, 215, 50, 70);
        b2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Moves.u();
                    panel.repaint();
                }
            }
        );
        panel.add(b2);

        JButton b3 = new JButton("e");
        b3.setBounds(440, 385, 50, 70);
        b3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Moves.e();
                    panel.repaint();
                }
            }
        );
        panel.add(b3);

        JButton b4 = new JButton("d");
        b4.setBounds(440, 465, 50, 70);
        b4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Moves.d();
                    panel.repaint();
                }
            }
        );
        panel.add(b4);

        JButton b5 = new JButton("E");
        b5.setBounds(840, 295, 50, 70);
        b5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Moves.E();
                    panel.repaint();
                }
            }
        );
        panel.add(b5);

        JButton b6 = new JButton("D");
        b6.setBounds(840, 375, 50, 70);
        b6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Moves.D();
                    panel.repaint();
                }
            }
        );
        panel.add(b6);

        JButton b7 = new JButton("R");
        b7.setBounds(755, 150, 70, 50);
        b7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Moves.R();
                    panel.repaint();
                }
            }
        );
        panel.add(b7);

        JButton b8 = new JButton("m");
        b8.setBounds(675, 150, 70, 50);
        b8.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Moves.m();
                    panel.repaint();
                }
            }
        );
        panel.add(b8);

        JButton b9 = new JButton("l");
        b9.setBounds(595, 150, 70, 50);
        b9.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Moves.l();
                    panel.repaint();
                }
            }
        );
        panel.add(b9);

        JButton b10 = new JButton("r");
        b10.setBounds(665, 550, 70, 50);
        b10.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Moves.r();
                    panel.repaint();
                }
            }
        );
        panel.add(b10);
        
        JButton b11 = new JButton("M");
        b11.setBounds(585, 550, 70, 50);
        b11.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Moves.M();
                    panel.repaint();
                }
            }
        );
        panel.add(b11); 

        JButton b12 = new JButton("L");
        b12.setBounds(505, 550, 70, 50);
        b12.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Moves.L();
                    panel.repaint();
                }
            }
        );
        panel.add(b12);
        
        JButton b13 = new JButton("F");
        b13.setBounds(755, 530, 45, 25);
        b13.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Moves.F();
                    panel.repaint();
                }
            }
        );
        panel.add(b13);
        
        JButton b14 = new JButton("S");
        b14.setBounds(785, 500, 45, 25);
        b14.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Moves.S();
                    panel.repaint();
                }
            }
        );
        panel.add(b14);
        
        JButton b15 = new JButton("b");
        b15.setBounds(815, 470, 45, 25);
        b15.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Moves.b();
                    panel.repaint();
                }
            }
        );
        panel.add(b15);

        JButton b16 = new JButton("f");
        b16.setBounds(452, 273, 45, 25);
        b16.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Moves.f();
                    panel.repaint();
                }
            }
        );
        panel.add(b16);

        JButton b17 = new JButton("s");
        b17.setBounds(482, 243, 45, 25);
        b17.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Moves.s();
                    panel.repaint();
                }
            }
        );
        panel.add(b17);

        JButton b18 = new JButton("B");
        b18.setBounds(512, 213, 45, 25);
        b18.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Moves.B();
                    panel.repaint();
                }
            }
        );
        panel.add(b18);

        JButton b19 = new JButton("X");
        b19.setBounds(385,305,50,230);
        b19.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Moves.X();
                    panel.repaint();
                }
            }
        );
        panel.add(b19);
        
        JButton b20 = new JButton("x");
        b20.setBounds(895,215,50,230);
        b20.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Moves.x();
                    panel.repaint();
                }
            }
        );
        panel.add(b20);
        
        JButton b21 = new JButton("Y");
        b21.setBounds(595,95,230,50);
        b21.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Moves.Y();
                    panel.repaint();
                }
            }
        );
        panel.add(b21);
        
        JButton b22 = new JButton("y");
        b22.setBounds(505,605,230,50);
        b22.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Moves.y();
                    panel.repaint();
                }
            }
        );
        panel.add(b22);
        
        //功能：将魔方复位到未被打乱状态
        JButton b23 = new JButton("重置");
        b23.setBounds(1300,300,60,40);
        b23.setBackground(lightblue);
        b23.setBorder(null);
        b23.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Moves.reset();
                    panel.repaint();
                }
            }
        );
        panel.add(b23);
        
        //功能：随机生成并执行一个打乱公式
        JButton b24 = new JButton("新的打乱");
        b24.setBounds(1170,300,60,40);
        b24.setBackground(lightblue);
        b24.setBorder(null);
        b24.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // 将耗时操作放置在新的线程内完成                 
                    new Thread(new Runnable() {                    
                        public void run() {
                            enableButtons(buttons,false); 
                            Moves.reshuffle();
                            enableButtons(buttons,true);    
                        }               
                    }).start();               
                }
            
        });
        panel.add(b24);

        //功能：将魔方恢复到刚刚执行完“新的打乱”后的状态
        JButton b25 = new JButton("回到打乱");
        b25.setBounds(1235,300,60,40);
        b25.setBackground(lightblue);
        b25.setBorder(null);
        b25.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    Moves.load_reshuffle();
                    panel.repaint();
                }
            }
        );
        panel.add(b25);
        
        //功能：复原底层的四个棱块（固定以黑色为底面）
        JButton b26 = new JButton("复原底层十字");
        b26.setBounds(1170,390,190,40);
        b26.setBackground(lightblue);
        b26.setBorder(null);
        b26.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 将耗时操作放置在新的线程内完成                  
                new Thread(new Runnable() {                    
                    public void run() {
                        enableButtons(buttons,false); 
                        cross.run();
                        enableButtons(buttons,true); 
                    }               
                }).start();               
            }
        });
        panel.add(b26);

        //功能：复原底层和第二层（固定以黑色为底面），前提是上一步已完成（用户完成或自动完成都可以），否则弹出提示窗
        JButton b27 = new JButton("复原前两层");
        b27.setBounds(1170,435,190,40);
        b27.setBackground(lightblue);
        b27.setBorder(null);
        b27.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 将耗时操作放置在新的线程内完成                  
                new Thread(new Runnable() {                    
                    public void run() {
                        enableButtons(buttons,false);    
                        f2l.run();
                        enableButtons(buttons,true); 
                    }               
                }).start();               
            }
        });
        panel.add(b27);

        //功能：复原顶面（固定以黑色为底面），前提是上一步已完成（用户完成或自动完成都可以），否则弹出提示窗
        JButton b28 = new JButton("复原顶层朝向");
        b28.setBounds(1170,480,190,40);
        b28.setBackground(lightblue);
        b28.setBorder(null);
        b28.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 将耗时操作放置在新的线程内完成                  
                new Thread(new Runnable() {                    
                    public void run() {
                        enableButtons(buttons,false);
                        oll.run();
                        enableButtons(buttons,true); 
                    }               
                }).start();               
            }
        });
        panel.add(b28);

        //功能：复原顶层（固定以黑色为底面），前提是上一步已完成（用户完成或自动完成都可以），否则弹出提示窗
        JButton b29 = new JButton("复原顶层排列");
        b29.setBounds(1170,525,190,40);
        b29.setBackground(lightblue);
        b29.setBorder(null);
        b29.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 将耗时操作放置在新的线程内完成                  
                new Thread(new Runnable() {                    
                    public void run() {
                        enableButtons(buttons,false);
                        pll.run();
                        enableButtons(buttons,true); 
                    }               
                }).start();               
            }
        });
        panel.add(b29);

        JButton b30 = new JButton("一键复原");
        b30.setBounds(1170,345,190,40);
        b30.setBackground(lightblue);
        b30.setBorder(null);
        b30.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 将耗时操作放置在新的线程内完成                  
                new Thread(new Runnable() {                    
                    public void run() {
                        enableButtons(buttons,false);
                        cross.run();
                        f2l.run();
                        oll.run();
                        pll.run();
                        enableButtons(buttons,true); 
                    }               
                }).start();               
            }
        });
        panel.add(b30);

        buttons[0]=b1;
        buttons[1]=b2;
        buttons[2]=b3;
        buttons[3]=b4;
        buttons[4]=b5;
        buttons[5]=b6;
        buttons[6]=b7;
        buttons[7]=b8;
        buttons[8]=b9;
        buttons[9]=b10;
        buttons[10]=b11;
        buttons[11]=b12;
        buttons[12]=b13;
        buttons[13]=b14;
        buttons[14]=b15;
        buttons[15]=b16;
        buttons[16]=b17;
        buttons[17]=b18;
        buttons[18]=b19;
        buttons[19]=b20;
        buttons[20]=b21;
        buttons[21]=b22;
        buttons[22]=b23;
        buttons[23]=b24;
        buttons[24]=b25;
        buttons[25]=b26;
        buttons[26]=b27;
        buttons[27]=b28;
        buttons[28]=b29;
        buttons[29]=b30;

        //将引用映射到同一个内存空间，使这些类、对象都可以更新魔方状态或刷新图形界面
        panel.color = cubeColor;
        Moves.color = cubeColor;
        Moves.panel = panel;

        frame.setVisible(true);
       
    }
    
    //此方法用于使能或禁用所有按钮，可禁止类似于“同时打乱和还原魔方”的冲突操作
    public static void enableButtons(JButton[] buttons,boolean en){
        for (JButton button : buttons) {
            button.setEnabled(en);
        }
    }
}
