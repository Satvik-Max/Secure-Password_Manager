import java.util.Random;
class password_Generator
{
    String Pass_Gen()
    {
        StringBuffer pass1 = new StringBuffer();

        String alphabets = "1qwe2rtyui3opa4sdfg5hjklz6xcvb7!@#$%^nmQW8ERTY9UIOP0ASDFGHJKLZXCVBNM&*?=+-_";

        Random r = new Random();
        for(int i = 0; i < 8; i++) 
        {
            int randomindex = r.nextInt(alphabets.length());
            pass1.append(alphabets.charAt(randomindex));         
        }
        String Gen_Pass = pass1.toString();
        return Gen_Pass;  
    }
    public static void main(String[] args) {

                   
    }
}