import React from "react";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import Container from "@material-ui/core/Container";
import axiosInstance from "../axios";
import { Grid } from "@material-ui/core";
import SuccesAlert from "./SuccesAlert"
import { Link } from 'react-router-dom';

class Verification extends React.Component {
    constructor(){
        super();
        this.state = {
            codactivare:0,
           
        };
    }



     handleInput = event => {
         const {value,name} = event.target;
         console.log(value);
         this.setState({
             [name]:value
         })
     };

     onSubmitFun = event => {
         event.preventDefault();
         let Validation = {
             //trebuie sa se numeasca la fel ca in dto
             cod_activare:this.state.codactivare,
             email:localStorage.getItem("EMAIL")
            }
         axiosInstance.put("/validateSignUp", Validation)
             .then(res =>{
                 console.log( res.data);
                 Validation=res.data;
                 console.log(res.data);
                // this.setState({
                  //   alert_message:"success"
                // })

                if(localStorage.getItem("COD")=== this.state.codactivare)
                {
                   
                       this.setState({
                   alert_message:"success"
                })
                console.log(this.state.alert_message)
                     
                }
                if(localStorage.getItem("COD") !== this.state.codactivare)
                {
                    
                    this.setState({
                        alert_message:"fail"
                    })
                    console.log(this.state.alert_message)
                }
        
               
              

             }).catch(error => {
                 console.log(error);
             })


     }

    render() {
        return (
            <Container maxWidth="sm">
                <div>
                    <Grid>
                       
                        <form onSubmit={this.onSubmitFun}>
                        <TextField
                                variant="outlined"
                                margin="normal"
                                required
                                fullWidth
                                id="codactivare"
                                label="Cod activare"
                                type="number"
                                name="codactivare"
                                autoComplete="string"
                                onChange={this.handleInput}
                                autoFocus
                            />



                            
                             
                            <Button 
                                onSubmit=""
                                type="submit"
                                fullWidth
                                variant="contained"
                                color="primary"
                            >
                                Validare cod
                </Button>
               
                        </form>
                        {this.state.alert_message==="success" &&  this.state.alert_message !=="fail"? <SuccesAlert/> : null}
                        {this.state.alert_message==="fail"&&  this.state.alert_message !=="succes" ? <div>Codul introdus este gresit</div> : null}
                    </Grid>
                </div>
            </Container>
        );
    }


}
export default Verification;