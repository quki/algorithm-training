package quki.algorithm.math;

/**
 * 한자리만 바꾸기
 * 
 * @author quki
 *
 */
public class DigitChange {

	/**
	 * origin의 index 자리에 있는 수를 digit으로 바꾸기
	 * 
	 */
	public static int change(int index, int digit, int origin){
		
		String temp = Integer.toString(origin);
		StringBuilder sb = new StringBuilder(temp);
		sb.setCharAt(index, (char) (digit + '0'));
				
		return Integer.parseInt(sb.toString());
		
	}
	
	public static void main(String[] args) {
		int origin = 1234;
		System.out.println(change(0, 9, origin));
		
		
	}

}
