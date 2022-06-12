package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JTextField;

public class HintTextField_main extends JTextField{

	Font gainFont = new Font("a소나무L", Font.PLAIN, 12);
	Font lostFont = new Font("a소나무L", Font.ITALIC, 12);
	
	public HintTextField_main(final String hint) {
		
		setText(hint);				//hint로 글자를 받아와서 넣어둠.
		setFont(lostFont);			//설정한 lostFont로 Font를 설정함.	
		setForeground(Color.GRAY);	//글자색 변경
		
		this.addFocusListener(new FocusAdapter() {  
			   
		       @Override  
		       public void focusGained(FocusEvent e) {  //포커스를 얻으면
		         if (getText().equals(hint)) {  		//hint 글씨가 써있으면
		           setText("");  						//텍스트 필드에서 힌트 텍스트를 지움.
		           setFont(gainFont);  					//gainFnt로 Font설정.
		           setForeground(Color.BLACK);			//쓸 때 글자색은 검정색.
		         } else {  
		           setText(getText());  				
		           setFont(gainFont);  
		         }  
		       }  
		   
		       @Override  
		       public void focusLost(FocusEvent e) {  					//포커스를 잃으면
		         if (getText().equals(hint)|| getText().length()==0) {  //hint text가 있는 상태+아무 글씨도 쓰지 않은 상태면
		           setText(hint);  										//다시 hint 글자를 세팅
		           setFont(lostFont);  									//Font는 그대로 lostFont
		           setForeground(Color.GRAY);  							//글자색은 그레이
		         } else {  												//다른 글자가 있다면
		           setText(getText());  								
		           setFont(gainFont);  									
		           setForeground(Color.BLACK);  						
		         }  
		       }  
		     });  
		   
	}
	
}
