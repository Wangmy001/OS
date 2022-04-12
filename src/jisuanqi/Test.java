package jisuanqi;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test 
    {
	    Button num[],oper[],Point,Equal,C,sqrt,pingfang,lifang;
	    TextField txtAnswer;
	    Panel p;
	    Frame f;
	    double num1,num2;
	    char k;//运算符
	    boolean isNum;
	    public static void main(String args[])
	    {
	    	Test calGUI=new Test();
	        calGUI.go();
	    }
	    
	    public void go()
	    {
    	f=new JFrame("阿言的计算器");
	    p=new Panel();
    	txtAnswer=new TextField("0",50);
    	num=new Button[10];
    	for(int i=0;i<10;i++)
    	{
    		num[i]=new Button(i+"");
    	}
    	Point=new Button(".");
    	Equal=new Button("=");
    	oper=new Button[4];
    	C=new Button("C");
    	sqrt=new Button("sqrt");
    	pingfang=new Button("pingfang");
    	lifang=new Button("lifang");
    	oper[0]=new Button("+");
    	oper[1]=new Button("-");
    	oper[2]=new Button("*");
    	oper[3]=new Button("/");
    	p.setLayout(new GridLayout(5,4));
    	p.add(sqrt);
    	p.add(pingfang);
    	p.add(lifang);
    	p.add(C);
    	
	    p.add(num[7]);
    	p.add(num[8]);
	    p.add(num[9]);
    	p.add(oper[0]);
	    p.add(num[4]);
    	p.add(num[5]);
	    p.add(num[6]);
    	p.add(oper[1]);
	    p.add(num[1]);
    	p.add(num[2]);
	    p.add(num[3]);
    	p.add(oper[2]);
	    p.add(Point);
    	p.add(num[0]);
	    p.add(Equal);
    	p.add(oper[3]);
	    f.setSize(300,300);
    	f.setLayout(new BorderLayout());
        f.add(txtAnswer,"North");
    	f.add(p, "Center");
	    f.setVisible(true);
	    
	    f.addWindowListener(new MyWinLis());
	    MyNumLis mnl=new MyNumLis();
	    for(int i=0;i<10;i++)
	    	num[i].addActionListener(mnl);
	    MyOperLis mol=new MyOperLis();
	    for(int j=0;j<4;j++)
	    	oper[j].addActionListener(mol);
	    MyEqualLis mel=new MyEqualLis();
	    Equal.addActionListener(mel);
	    MyPointLis mpol=new MyPointLis();
	    Point.addActionListener(mpol);
	    MyCLis mcl=new MyCLis();
	    C.addActionListener(mcl);
	    MySqrtLis msl=new MySqrtLis();
	    sqrt.addActionListener(msl);
	    MyPingfangLis mpl=new MyPingfangLis();
	    pingfang.addActionListener(mpl);
	    MyLifangLis mll=new MyLifangLis();
	    lifang.addActionListener(mll);
    	} 
	    
	    class MyNumLis implements ActionListener
	    {
	    	public void actionPerformed(ActionEvent e) 
			{
				String t=e.getActionCommand();
				String s=txtAnswer.getText();
				if(isNum==true)
					txtAnswer.setText(s+t);
				else
					txtAnswer.setText(t);
				isNum=true;
			}
	    }
	    class MyOperLis implements ActionListener
	    {
			
			public void actionPerformed(ActionEvent e) 
			{
				num1=Double.parseDouble(txtAnswer.getText());//转换为Double
				k=e.getActionCommand().charAt(0);
				isNum=false;
			}
	    }
	    class MyPointLis implements ActionListener
	    {
			
			public void actionPerformed(ActionEvent e) 
			{
				String s=txtAnswer.getText();
				if(isNum==true)
					txtAnswer.setText(s+".");
			}
	    }
	    class MyEqualLis implements ActionListener
	    {
			
			public void actionPerformed(ActionEvent e) 
			{
				double result=0;
				isNum=false;
				num2=Double.parseDouble(txtAnswer.getText());
				switch(k)
				{
				case'+':result=num1+num2;break;
				case'-':result=num1-num2;break;
				case'*':result=num1*num2;break;
				case'/':result=num1/num2;break;
				}
				txtAnswer.setText(result+"");
			}
	    }
	    class MyCLis implements  ActionListener
	    {
			
			public void actionPerformed(ActionEvent e) 
			{
				txtAnswer.setText("");
			    isNum=false;
			}
	    }
	    class MySqrtLis implements  ActionListener
	    {
			
			public void actionPerformed(ActionEvent e) 
			{
			    double t=Double.parseDouble(txtAnswer.getText());
			    txtAnswer.setText(Math.sqrt(t)+"");
			    isNum=false;
			}
	    }
	    class MyPingfangLis implements  ActionListener
	    {
			
			public void actionPerformed(ActionEvent e) 
			{
			    num1=Double.parseDouble(txtAnswer.getText());
			    txtAnswer.setText(num1*num1+"");
			}
	    }
	    class MyLifangLis implements  ActionListener
	    {
			
			public void actionPerformed(ActionEvent e) 
			{
				num1=Double.parseDouble(txtAnswer.getText());
			    txtAnswer.setText(num1*num1*num1+"");
			}
	    }
	    class MyWinLis extends WindowAdapter
	    {
			
			public void windowClosing(WindowEvent e)
			{
				e.getWindow().setVisible(false);
				e.getWindow().dispose();
				System.exit(0);
			}
	    }
}
