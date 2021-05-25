import React from 'react'

import { Avatar, Button, List, ListItemIcon, ListItem, ListItemText, Typography, TextField  } from '@material-ui/core';
import axiosInstance from "../axios";
import { makeStyles } from '@material-ui/core/styles';
import GridList from '@material-ui/core/GridList';
import GridListTile from '@material-ui/core/GridListTile';
import GridListTileBar from '@material-ui/core/GridListTileBar';
import IconButton from '@material-ui/core/IconButton';
import InfoIcon from '@material-ui/icons/Info';
import './CosProduct.css';
import DeleteIcon from '@material-ui/icons/Delete';
import CheckIcon from '@material-ui/icons/Check';
import ModificaCantitate from './ModificaCantitate';


class WishList extends React.Component {

    
   

    constructor(){
        super();
        this.state = {
            parfumuri: [],
            idParf:0,
            
           
          


        }
       

    }


  
    saveIdParfum(idd)
    {
       this.setState({ idParf: idd});
    }


   


    handleInput = event => {
        const {value,name} = event.target;
        console.log(value);
        this.setState({
            [name]:value
        })
    }
    
  
    


    
    componentDidMount(){
        axiosInstance.get("http://localhost:8080/user/parfumuriWishList" + localStorage.getItem("USER_ID"))
        .then(res => {
            let val = res.data;
            this.setState({
                parfumuri: val
            });
            console.log(val);
            console.log(this.state.parfumuri)
        
            
        }

        )
        .catch(error => {
            console.log(error)
        })

        
       
    
    }




     handleSubmit1 = event => {
         event.preventDefault();
         let UserParfum = {
             //trebuie sa se numeasca la fel ca in java in dto
            
             idUser:localStorage.getItem("USER_ID"),
             idParfum:this.state.idParf,
             //reviewID:this.state.idReview
            
         }
         axiosInstance.put("http://localhost:8080/user/stergeParfumWishList", UserParfum)
         .then(
             res => {
                 console.log(res.data.id)
                 UserParfum = res.data;
                 console.log(res.data);
             }
         )
         .catch(error => {
             console.log(error)
         });
     }

    
   
    

        
    // <CheckIcon/>
     render() {
        
         
        
        if( localStorage.getItem("ROLE") === "USER")
        {

        
        return (

          
           
            <React.Fragment>

                

               
                <List>
                    {this.state.parfumuri.map(parfum => (
                        <ListItem key={parfum.id}>
                            
                            <img src={parfum.filename} alt={parfum.numeparfum}  height="100" width="100"/>
                            
                            <ListItemText primary = { " Nume: " + parfum.numeparfum + " Producator: " + parfum.producator}
                           secondary = { "Pret: " + parfum.pret + "  Stoc: "  + parfum.cantitate} />
                    

                         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;


                        
              
             

                


                        <form onSubmit={this.handleSubmit1}>
                            <Button
                         onClick={() => {
                        
                            this.saveIdParfum(parfum.id);
                            window.location.href = "/wishList"
                          }}
                           
                            variant="contained"
                            color="secondary"
                            id="create"
                            type="submit" 
                                startIcon={<DeleteIcon />}>                  
                                Delete
                            </Button>
                         </form> 

                        </ListItem>

                        
                       

                    ))}
                </List>
                
            </React.Fragment>
               
                
                    
        )
                    }
                    else
                    {
                        throw new Error("Trebuie sa intri in contul de client");
                        
                    }
                   
                    
                    
    }




}

export default WishList;