//Code for Transposition Cipher with XoR Cipher for ENcryption
import java.util.*;
public class CSSAlgo
{
	static int size_row(int size)
	{
		int row = (int)Math.sqrt(size);
		return row;
	}

	static int size_column(int row,int size)
	{
		int column = 0;
		for(int i=row;i<size;i++)
		{
			if((row * i) >= size)
			{
				column = i;
				break;
			}
		}
		return column;
	}

	static void noiseInput(char charArray[],int string_size,int elements)
	{
		
		for(int i=string_size;i<elements;i++)
		{
			charArray[i] = 'X';
		}
	}
	static void convertToMatrix(char spiral_matrix[][],char charArray[],int string_size,int matrix_row,int matrix_col)
	{
		
		int top = 0,bottom = matrix_row - 1;
		int left = 0,right = matrix_col - 1;
		int index = 0;
		while(true)
		{
			if(left > right)
				break;
			

			//top row
			for(int i=left;i<=right;i++)
			{
				spiral_matrix[top][i] = charArray[index++];
			}
			top++;

			if(top > bottom)
				break;

			//right column
			for(int i=top;i<=bottom;i++)
			{
				spiral_matrix[i][right] = charArray[index++];
			}
			right--;

			if(left > right)
				break;

			//bottom row

			for(int i=right;i>=left;i--)
			{
				spiral_matrix[bottom][i] = charArray[index++];
			}
			bottom--;

			if(top>bottom)
				break;

			//left column
			for(int i=bottom;i>=top;i--)
			{
				spiral_matrix[i][left] = charArray[index++];
			}
			left++;
		}
	}

        
		static void MatrixToArray(char spiral_matrix[][],char charArray[],int string_size,int matrix_row,int matrix_col)
		{
			int row = matrix_row/2;
			int col = matrix_col/2;
			while(true)
			{
				if(spiral_matrix[row][col] == 'X')
					spiral_matrix[row][col] =' ';

			}
		}
                static void decryptSpiral(char spiral_matrix[][],char charArray[],int size,int matrix_row,int matrix_col){
                    
                        for(int i=0;i<matrix_row;i++){
                            for(int j=0;j<matrix_col;j++){
                                
                            }
                        }
                        int top = 0,bottom = matrix_row - 1;
		int left = 0,right = matrix_col - 1;
		int index = 0;
		while(true)
		{
			if(left > right)
				break;
			

			//top row
			for(int i=left;i<=right;i++)
			{
				 charArray[index++]=spiral_matrix[top][i] ;
			}
			top++;

			if(top > bottom)
				break;

			//right column
			for(int i=top;i<=bottom;i++)
			{
				charArray[index++]=spiral_matrix[i][right];
			}
			right--;

			if(left > right)
				break;

			//bottom row

			for(int i=right;i>=left;i--)
			{
				 charArray[index++]=spiral_matrix[bottom][i] ;
			}
			bottom--;

			if(top>bottom)
				break;

			//left column
			for(int i=bottom;i>=top;i--)
			{
				charArray[index++]=spiral_matrix[i][left] ;
			}
			left++;
                }
                }

		static String Encryption(String toEncrypt)
		{
			char[] symbols = {'~','`','!','@','#','$','%','^','&','*','(',')','-','+','=',':',';'};
			char[] output = new char[toEncrypt.length()];
			char x;
			for(int i=0;i<toEncrypt.length();i++)
			{
				if(toEncrypt.charAt(i) == ' ')
				{
					output[i] = '?';
				}
				else
				{
					x = symbols[i % symbols.length];
					output[i] = (char)(toEncrypt.charAt(i) ^ x);
				}
			}
			String abc = String.valueOf(output);
			
			return abc;
		}

		static String Decryption(String toDecrypt)
		{
			char[] symbols = {'~','`','!','@','#','$','%','^','&','*','(',')','-','+','=',':',';'};
			char[] output = new char[toDecrypt.length()];
			char x;
			for(int i=0;i<toDecrypt.length();i++)
			{
				if(toDecrypt.charAt(i) == '?')
				{
					output[i] = ' ';
				}
				else
				{
					x = symbols[i % symbols.length];
					output[i] = (char)(toDecrypt.charAt(i) ^ x);
				}
			}
			String abc = String.valueOf(output);
			
			return abc;
		}

		public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter plain text: ");
		String text = in.nextLine();
		int string_size = text.length();

		final int matrix_row = size_row(string_size);
		final int matrix_col = size_column(matrix_row,string_size);
		int elements = matrix_row * matrix_col;
		char charArray[] = new char[elements];
		for(int i=0;i<string_size;i++)
		{
			charArray[i] = text.charAt(i);
		}
		noiseInput(charArray,string_size,elements);

		 char[][] spiral_matrix = new char[matrix_row][matrix_col];
		 convertToMatrix(spiral_matrix,charArray,string_size,matrix_row,matrix_col);
		/*System.out.println("Spiral Matrix!!");
		 for(int i=0;i<matrix_row;i++)
		 {
		 	System.out.println(Arrays.toString(spiral_matrix[i]));
		 }*/
		 int k=0;
		 for(int i=0;i<matrix_row;i++)
		 {
		 	for(int j=0;j<matrix_col;j++)
		 	{
		 		charArray[k++] = spiral_matrix[i][j]; 
		 	}
		 }

		 text = String.valueOf(charArray);



		 String EncryptedMessage = Encryption(text);

		  System.out.println("Encrypted Message is: "+EncryptedMessage);

		String DecryptedMessage = Decryption(EncryptedMessage);
		//System.out.println("Decrypted Message is "+DecryptedMessage);
                charArray = DecryptedMessage.toCharArray();
                
                decryptSpiral(spiral_matrix,charArray,string_size,matrix_row,matrix_col);
                
                String decryptedPlainText=String.valueOf(charArray);
                
                decryptedPlainText=decryptedPlainText.replace("X", " ");
                
                    System.out.println("Decrypted Message :"+decryptedPlainText);
		charArray = text.toCharArray();
		k=0;
		 for(int i=0;i<matrix_row;i++)
		 {
		 	for(int j=0;j<matrix_col;j++)
		 	{
		 		spiral_matrix[i][j]=charArray[k++]; 
		 	}
		 }

		 MatrixToArray(spiral_matrix,charArray,string_size,matrix_row,matrix_col);
	
	}

}
