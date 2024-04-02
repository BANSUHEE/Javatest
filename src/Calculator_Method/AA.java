package Calculator_Method;

class AA{
   private int aa;
   
   public AA(){
      
   }

   public int getA() {
      return aa;
   }
   public void setA(int a) {
      this.aa = aa;
   }
   
}



class BB{
   private int aa;
   
   public BB(){
      
   }

   public int getA() {
      return aa;
   }
   public void setA(int aa) {
      this.aa = aa;
   }
   
}


class CC{
   private int aa;
   
   public CC(){
      
   }

   public int getA() {
      return aa;
   }
   public void setA(int aa) {
      this.aa = aa;
   }
   
}





class HasA2 {
   private AA aa;
   private BB bb;
   private CC cc;
   
   

   public AA getAa() {
      return aa;
   }
   public void setAa(AA aa) {
      this.aa = aa;
   }



   public BB getBb() {
      return bb;
   }
   public void setBb(BB bb) {
      this.bb = bb;
   }



   public CC getCc() {
      return cc;
   }
   public void setCc(CC cc) {
      this.cc = cc;
   }



   public static void main(String[] args) {
	      HasA2 has = new HasA2();
	      AA a = new AA();
	      BB B = new BB();
	      CC C = new CC();
	      
	     /* a.setA(5);
	      has.setAA(a);
	      
	      System.out.println(has.getAA());
	      
	     */ 
	   }

}

