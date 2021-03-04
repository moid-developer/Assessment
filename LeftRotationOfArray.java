import java.util.Scanner;
import java.util.Arrays;
public class LeftRotationOfArray{
	public static void main(String[] args){
		Integer size=0;
		Integer rp=0;
		Integer indexRP=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of Array: ");
		size=sc.nextInt();
		Integer [] arr=new Integer[size];
		System.out.println("Enter the "+size+" element of array: ");
		for (int i=0;i<size;i++){
			arr[i]=sc.nextInt();
		}
		System.out.println("Enter the rotational point of Array element: ");
		rp=sc.nextInt();
		// find index of given number
		indexRP=Arrays.asList(arr).indexOf(rp);
		rotatedElement(arr,size,indexRP);
	}
	public static void rotatedElement(Integer []arr,Integer size,Integer rp){
		Integer tempArr[]=new Integer[size];
		int count=0;
		for (int i=rp;i<size;i++){
			tempArr[count]=arr[i];
			count++;
		}
			
		for (int i=0;i<rp;i++){
			tempArr[count]=arr[i];
			count++;
		}

		for (int i=0;i<size;i++)
				System.out.print(tempArr[i]+" ");
	}
}
