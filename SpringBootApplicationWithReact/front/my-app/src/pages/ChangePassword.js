import React from "react";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import Container from "@material-ui/core/Container";
import axiosInstance from "../axios";
import { Grid } from "@material-ui/core";


class ChangePassword extends React.Component {
        constructor(){
            super();
            this.state = {
                userID:0,
                oldPassword:"",
                newPassword:"",
                confirmPassword:"", 
                invalid:false,
                displayError:false,
                errors: {
                    newPassword: '',
                    confirmPassword: '',
                },
                
            };
        }



        handleInput = event => {
            const {value,name} = event.target;
            console.log(value);
            let errors = this.state.errors;
            switch (name) {
                case 'newPassword':
                    errors.newPassword =
                        value.length < 3
                            ? 'Password must be 3 characters long!'
                            : '';
                    break;
                case 'confirmPassword':
                    errors.confirmPassword =
                        value.length < 3
                            ? 'Password must be 3 characters long!'
                            : '';
                    break;
    
    
            }
            this.setState({ errors, [name]: value }, () => {
                console.log(errors)
            })
        };

      

        onSubmitFun = event => {
            event.preventDefault();
            if(this.state.newPassword.length > 2 && this.state.confirmPassword.length>2){
            let dto = {
                userID:localStorage.getItem("USER_ID"),
                oldPassword: this.state.oldPassword,
                newPassword : this.state.newPassword,
                confirmPassword : this.state.confirmPassword,

            }
            axiosInstance.put("/user/changePassword", dto)
                .then(res =>{
                    
                    console.log(res.data);
                    if(this.state.newPassword === this.state.confirmPassword){
                    localStorage.removeItem("USER_ID");
                    this.props.history.push("/log-in");
                    window.location.href = "/log-in";
                   
                    }
                    else
                    {
                        this.setState({
                            displayError :true
                        });
                    }

                }).catch(error => {
                    console.log(error);
                })
            }
            else{
               this.setState({
                   invalid:true,
               })
    
            }


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
                                    id="oldPassword"
                                    label="Old Password"
                                    type="password"
                                    name="oldPassword"
                                    autoComplete="string"
                                    onChange={this.handleInput}
                                    autoFocus
                                />


                               
                                <TextField
                                    variant="outlined"
                                    margin="normal"
                                    required
                                    fullWidth
                                    id="newPassword"
                                    label="New Password"
                                    type="password"
                                    name="newPassword"
                                    autoComplete="string"
                                    onChange={this.handleInput}
                                    autoFocus
                                />
                                {this.state.errors.newPassword.length > 0 &&
                                <span className='error'>{this.state.errors.newPassword}</span>}
                                <TextField
                                    variant="outlined"
                                    margin="normal"
                                    required
                                    fullWidth
                                    name="confirmPassword"
                                    label="Confirm New Password"
                                    type="password"
                                    id="confirmPassword"
                                    onChange={this.handleInput}
                                    autoComplete="current-password"
                                />
                                 {this.state.errors.confirmPassword.length > 0 &&
                                <span className='error'>{this.state.errors.confirmPassword}</span>}
                                
                                <Button
                                    type="submit"
                                    fullWidth
                                    variant="contained"
                                    color="primary"
                                >
                                    Resetare parola
                    </Button>
                            </form>
                            
                        </Grid>
                    </div>
                    {this.state.displayError === true ?
                    <div>
                        
                    </div>
                    :null}
                       {this.state.invalid === true ? <h2>Format invalid!</h2>:null}

                   
                  
                </Container>
            );

        }
      
        
    

}
export default ChangePassword;