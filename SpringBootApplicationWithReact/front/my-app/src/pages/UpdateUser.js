import React , {useState} from "react"
import { Avatar, Button, List, ListItemIcon, ListItem, ListItemText, Typography, TextField  } from '@material-ui/core';
import axiosInstance from "../axios";
import { makeStyles } from '@material-ui/core/styles';
import GridList from '@material-ui/core/GridList';
import GridListTile from '@material-ui/core/GridListTile';
import GridListTileBar from '@material-ui/core/GridListTileBar';
import IconButton from '@material-ui/core/IconButton';
import InfoIcon from '@material-ui/icons/Info';




class UpdateUser extends React.Component {

    
   

    constructor(){
        super();
        this.state = {
         id: localStorage.getItem("IDUSERI") ,
         username:"",
         password:"",
         email:"",
         codactivare:0,
         rol:"",
         enable:false,
         
        }

    
    }


    componentDidMount(){
        axiosInstance.get("http://localhost:8080/user/" + this.state.id )
        .then(res => {
            let user = res.data;
            this.setState({
                id:user.id,
                username:user.username,
                password:user.password,
                email:user.email,
                codactivare:user.codactivare,
                rol:user.rol,
                enable:user.enable

            
            });
            
            console.log(res.data)
        }

        )
        .catch(error => {
            console.log(error)
        })
    }

    
    handleInput = event => {
        const {value,name} = event.target;
        console.log(value);
        this.setState({
            [name]:value
        })
    }

     handleSubmit = event => {
         event.preventDefault();
         let u = {
            id:this.state.id,
            username:this.state.username,
            password:this.state.password,
            email:this.state.email,
            codactivare:this.state.codactivare,
            rol:this.state.rol,
            enable:this.state.enable
            
             
         }
         this.props.history.push("/ListaUser")

         
         axiosInstance.put("http://localhost:8080/user/update", u)
         .then(
             res => {
                 console.log(res.data)
                 console.log(res.data.mesaj)
                 u = res.data;
                 console.log(res.data);
                 
             }
         )
         .catch(error => {
             console.log(error)
         });
     }


   


     render() {
        

        if( localStorage.getItem("ROLE") === "ADMIN")
        {
        
        return (
            
           
            <React.Fragment>

                <form onSubmit={this.handleSubmit}>
                    <Typography variant="h6" color="textPrimary" component="h6">
                        Update user
            </Typography>
                    <div>
                       
                    <div>
                            <Typography
                                variant="subtitle2"
                                color="textPrimary"
                                component="h2"
                            >
                                Id:
                </Typography>
                            <TextField
                                required={true}
                                value = {this.state.id}
                                id="required"
                                label="Id User"
                                name="id"
                                placeholder="id"
                                onChange={this.handleInput}
                                margin="normal"
                                variant="outlined"
                                autoComplete="off"
                            />
                        </div>


                        <div>
                            <Typography
                                variant="subtitle2"
                                color="textPrimary"
                                component="h2"
                            >
                                Username:
                </Typography>
                            <TextField
                                required={true}
                                value = {this.state.username}
                                id="required"
                                label="Username"
                                name="username"
                                placeholder="username"
                                onChange={this.handleInput}
                                margin="normal"
                                variant="outlined"
                                autoComplete="off"
                            />
                        </div>
                        <div>
                            <Typography
                                variant="subtitle2"
                                color="textPrimary"
                                component="h2"
                            >
                                Password:
                </Typography>
                            <TextField
                                required={true}
                                value = {this.state.password}
                                id="required"
                                label="Password"
                                name="password"
                                placeholder="password"
                                onChange={this.handleInput}
                                margin="normal"
                                variant="outlined"
                                autoComplete="off"
                            />
                        </div>
                        <div>
                            <Typography
                                variant="subtitle2"
                                color="textPrimary"
                                component="h2"
                            >
                                E-mail:
                </Typography>
                            <TextField
                                required={true}
                                value = {this.state.email}
                                id="required"
                                label=" E-mail"
                                name="email"
                                placeholder="email"
                                onChange={this.handleInput}
                                margin="normal"
                                variant="outlined"
                                autoComplete="off"
                            />
                        </div>

                        <div>
                            <Typography
                                variant="subtitle2"
                                color="textPrimary"
                                component="h2"
                            >
                              Cod activare
                </Typography>
                            <TextField
                                required={true}
                                value = {this.state.codactivare}
                                id="required"
                                label="Cod acrivare"
                                name="codactivare"
                                placeholder="codactivare"
                                onChange={this.handleInput}
                                margin="normal"
                                variant="outlined"
                                autoComplete="off"
                            />
                        </div>


                        <div>
                            <Typography
                                variant="subtitle2"
                                color="textPrimary"
                                component="h2"
                            >
                              Rol:
                </Typography>
                            <TextField
                                required={true}
                                value = {this.state.rol}
                                id="required"
                                label="Rol"
                                name="rol"
                                placeholder="rol"
                                onChange={this.handleInput}
                                margin="normal"
                                variant="outlined"
                                autoComplete="off"
                            />
                        </div>


                        <div>
                            <Typography
                                variant="subtitle2"
                                color="textPrimary"
                                component="h2"
                            >
                              Enable:
                </Typography>
                            <TextField
                                required={true}
                                value = {this.state.enable}
                                id="required"
                                label="Enable"
                                name="enable"
                                placeholder="enable"
                                onChange={this.handleInput}
                                margin="normal"
                                variant="outlined"
                                autoComplete="off"
                            />
                        </div>
                       
                    </div>
                    <div id="buttons">
                        <Button
                        onClick={() => {
                          
                            window.location.href = "/ListaUser"
                           
                         
                          }}
                            variant="contained"
                            color="secondary"
                            id="create"
                            type="submit"
                        >
                            Update User
              </Button>
                    </div>
                </form>
            </React.Fragment>
               
                
                    
        )
    }         
    else
    {
        throw new Error("Doar administratorul are acces");
    }   
                    
                    
                    
                    
    }




}

export default UpdateUser;