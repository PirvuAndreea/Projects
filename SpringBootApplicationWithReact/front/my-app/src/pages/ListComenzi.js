import React , {useState} from "react"
import { Avatar, Button, List, ListItemIcon, ListItem, ListItemText, Typography, TextField, Checkbox  } from '@material-ui/core';
import axiosInstance from "../axios";
import { makeStyles } from '@material-ui/core/styles';
import GridList from '@material-ui/core/GridList';
import GridListTile from '@material-ui/core/GridListTile';
import GridListTileBar from '@material-ui/core/GridListTileBar';
import IconButton from '@material-ui/core/IconButton';
import InfoIcon from '@material-ui/icons/Info';
import Filter from '../components/Filter';



class ListComenzi extends React.Component {

    
   

    constructor(){
        super();
        this.state = {
            
            comenzi: [],
           
            
        }
    }


   
    

    
    componentDidMount(){
        axiosInstance.get("http://localhost:8080/comanda")
        .then(res => {
            const val = res.data;
            this.setState({
                comenzi: val,
                

            });
            console.log(val);
            console.log(this.state.comenzi)
        }

        )
        .catch(error => {
            console.log(error)
        })

    }


   

   
   
    

    
     render() {
        
        if( localStorage.getItem("ROLE") === "ADMIN")
            {
            
        
        return (

           
            <React.Fragment> 
              <div>
               
               </div>

           

                <List>
                    {this.state.comenzi.map(comanda => (
                      
                        <ListItem>

                            
                            <Avatar>{"U"}</Avatar>
                            <ListItemText primary = { comanda.id+ " " + "Nume: " + comanda.nume +  ", " + "Prenume: " + 
                            comanda.prenume + ", " + "Oras: " + comanda.oras + ", " + "Adresa: " + comanda.adresa }
                                          secondary = {"Email: " + comanda.email + ", " + "Nr tel: " + comanda.nrtelefon + ", " + "Cod postal: " + comanda.codpostal}
                            
                            />
                            
                        </ListItem>  

                    ))}
                </List> 

               



               
            </React.Fragment>


                            
        )
    }
    else
    {
        throw new Error("Doar administratorul are acces");
    }
        
                    
                      
                    
    }
}

export default ListComenzi;