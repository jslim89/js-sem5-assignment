/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Js Lim
 */
public class PostcodeException extends NumberFormatException{

    public PostcodeException()
    {
        super();
    }
    public PostcodeException(String msg)
    {
        super(msg);
    }

    public void checkPostcode(String postcode)
    {
        if(postcode.length()!=5)
            throw new PostcodeException("Invalid Postcode: "+postcode);
    }
}
