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


class CosProduct extends React.Component {

    
   

    constructor(){
        super();
        this.state = {
            produse: [],
            
           idParf: 0,

         
          cantitate: 0,

        
          id: 0 ,
          valoare:0,
          cantitate:0,
          parfum:"",
          displayField: false,
          


        }
       

    }


  
    ceva(idd)
    {
       this.setState({ idParf: idd});
    }


    displayField = () => {
        this.setState({
            displayField: !this.state.displayField
        })
        console.log("Buton")
        console.log(this.state.displayField)

    }


    handleInput = event => {
        const {value,name} = event.target;
        console.log(value);
        this.setState({
            [name]:value
        })
    }
    
  
    


    
    componentDidMount(){
        axiosInstance.get("http://localhost:8080/user/produseCos" + localStorage.getItem("USER_ID"))
        .then(res => {
            let val = res.data;
            this.setState({
                produse: val
            });
            console.log(val);
            console.log(this.state.produse)
            console.log(this.state.produse.length)
            localStorage.setItem("COUNT",this.state.produse.length)
            
        }

        )
        .catch(error => {
            console.log(error)
        })

        
       
    
    }




    handleSubmit1 = event => {
        event.preventDefault();
        let UserProdus = {
            //trebuie sa se numeasca la fel ca in java in dto
            idProdusComanda:this.state.idParf,
            idUser:localStorage.getItem("USER_ID"),
            
            //reviewID:this.state.idReview
            
        }
        axiosInstance.put("http://localhost:8080/user/stergeProdusCos", UserProdus)
        .then(
            res => {
                console.log(res.data.id)
                UserProdus = res.data;
                console.log(res.data);
            }
        )
        .catch(error => {
            console.log(error)
        });
    }

    handleSubmit3 = event => {
        this.props.history.push("/finalizareComanda")
    
       }
   
    

        
    // <CheckIcon/>
     render() {
        
         
        
        if( localStorage.getItem("ROLE") === "USER")
        {

        
        return (

          
           
            <React.Fragment>

                

               
                <List>
                    {this.state.produse.map(produs => (
                        <ListItem key={produs.id}>
                            
                            <img src={produs.parfum.filename} alt={produs.parfum.numeparfum}  height="100" width="100"/>
                            
                            <ListItemText primary = { "Total: " + produs.valoare +  " Cantiate: " + produs.cantitate + " Nume: " + produs.parfum.numeparfum + " Producator: " + produs.parfum.producator}
                           secondary = { "Pret: " + produs.parfum.pret + "  Stoc: "  + produs.parfum.cantitate} />
                    

                         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;


                         {this.state.displayField ? (
                         <ModificaCantitate
                         data={produs.id}
                         history={this.props.history}
                        
                       />
                     ) : null}
                     
              
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                <Button
                        onClick={() => {
                          
                          this.setState({
                              id:produs.id
                              
                          })
                            
                            this.displayField()
                          
                            
                           
                         
                          }}
                            variant="contained"
                            color="secondary"
                            id="create"
                            type="submit"
                        >
                           Modifica cantitate
              </Button>

                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;


                        <form onSubmit={this.handleSubmit1}>
                            <Button
                         onClick={() => {
                        
                            this.ceva(produs.id);
                            window.location.href = "/shopping"
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
                <form onSubmit={this.handleSubmit3}>
                <Button className='addOrder'
                                type="submit"
                                width = "100"
                                variant="contained"
                                color="secondary"
                                
                            >
                                Finalizeaza comanda 
                </Button>
                </form>
                
                

                

              


                        

                
            </React.Fragment>
               
                
                    
        )
                    }
                    else
                    {
                        throw new Error("Trebuie sa intri in contul de client");
                        
                    }
                   
                    
                    
    }




}

export default CosProduct;