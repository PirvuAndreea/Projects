import React, {Component} from 'react'
import InfoIcon from '@material-ui/icons/Info';

class Contact extends Component{
    render()
    {
        return(
            <span>
               
            
            
           <h1> 
               <InfoIcon style={{ fontSize: "30px" ,
                color: 'black'}}></InfoIcon>
               Contact
           </h1>

            <h2>
                E-mail:   parfumShop@gmail.com
            </h2>
           
            <h2>
                Mobil:  078 (458) (522)
            </h2>

            </span>
        )
    }

}
export default Contact;