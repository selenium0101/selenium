package test;

public  abstract class AnonymousClass {

	AnonymousClass(){
	
	}

	abstract void  m1(String c);

	public static void main(String[] args) {

		AnonymousClass a=new AnonymousClass(){

			void m1(String val){
				System.out.println(val);
			}
		};

		a.m1("srinivas");
	}

}
