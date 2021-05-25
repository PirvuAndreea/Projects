import React, { useState } from "react"
import { Avatar, Button, List, ListItemIcon, ListItem, ListItemText, Typography, TextField } from '@material-ui/core';
import axiosInstance from "../axios";
import { makeStyles } from '@material-ui/core/styles';
import GridList from '@material-ui/core/GridList';
import GridListTile from '@material-ui/core/GridListTile';
import GridListTileBar from '@material-ui/core/GridListTileBar';
import IconButton from '@material-ui/core/IconButton';
import InfoIcon from '@material-ui/icons/Info';
import Container from "@material-ui/core/Container";
import { Grid } from "@material-ui/core";




class ForgotPassword extends React.Component {




    constructor() {
        super();
        this.state = {

            email: "",
            user:"",
            display:false,
            errors: {
               
                email:'',
              },
            inexistent:false,


        }


    }

    validEmailRegex = 
    RegExp(/^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i);


    handleInput = event => {
        const { value, name } = event.target;
        console.log(value);
        
        let errors = this.state.errors;
        switch (name) {
           case 'email': 
               errors.email = 
                 this.validEmailRegex.test(value)
                   ? ''
                   : 'Email is not valid!';
               break;
        }
        this.setState({ errors, [name]: value }, () => {
            console.log(errors)
        })
    }

      handleSubmit = event => {
          event.preventDefault();
          let dto = {
            email:this.state.email,
            
        }


          axiosInstance.put("http://localhost:8080/user/forgotPassword", dto)
          .then(
              res => {
                  
                  
                  console.log(res.data)
                  localStorage.setItem("FORGOT", res.data.forgotPassword)
                  localStorage.setItem("EMAIL", res.data.email)
                  this.setState({
                    display :true
                });
                console.log(this.state.display);
                  
                  
                 

              }
          )

          .catch(error => {
              this.setState({
                  inexistent:true
              })
              console.log(error)
          });
      }





    render() {




        return (


            
            <Container maxWidth="sm">
                Introduceti adresa de e-mail:
            <div>
                
                <Grid>

                    <form onSubmit={this.handleSubmit}>
                        <TextField
                            variant="outlined"
                            margin="normal"
                            required
                            fullWidth
                            id="email"
                            label="E-mail"
                            name="email"
                            autoComplete="string"
                            onChange={this.handleInput}
                            autoFocus
                        />
                            {this.state.errors.email.length > 0 &&
                                <span className='error'>{this.state.errors.email}</span>}
                        
                        <Button
                            type="submit"
                            fullWidth
                            variant="contained"
                            color="primary"
                        >
                            Introduceti email-ul
            </Button>
                    </form>
                    <br></br>
                   {this.state.display===true?
                   <div>
                       Veti primi un link pentru resetarea parolei
                   </div>
                   :null}
                   {this.state.inexistent === true ? <span>E-mail inexistent</span> : null}
                </Grid>
            </div>

           
        </Container>

        )
    }










}

export default ForgotPassword;