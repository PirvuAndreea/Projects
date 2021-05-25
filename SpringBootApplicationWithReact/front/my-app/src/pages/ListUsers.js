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
import * as SockJS from "sockjs-client";
import * as Stomp from "stompjs";


class ListUsers extends React.Component {

    
   

    constructor(){
        super();
        this.state = {
            
            users: [],
            idUser:0,
            
        }
    }


     ceva(idd)
         {
            this.setState({ idUser: idd});
         }
    

    

   
    

    componentDidMount(){
        this.connect();
        axiosInstance.get("http://localhost:8080/user")
        .then(res => {
            const val = res.data;
            this.setState({
                users: val,
                

            });
            console.log(val);
            console.log(this.state.users)
        }

        )
        .catch(error => {
            console.log(error)
        })

    }


     connect() {
        const URL = "http://localhost:8080/socket";
        const websocket = new SockJS(URL);
        const stompClient = Stomp.over(websocket);
        stompClient.connect({}, frame => {
            console.log("Conectat la " + frame);
            stompClient.subscribe("/topic/socket/user", notification => {
                let message = notification.body;
                console.log(message);
                alert(message);
                axiosInstance.get("http://localhost:8080/user")
                    .then(res => {
                        const val = res.data;
                        this.setState({
                            users: val,


                        })
                    });

            })
        })

    }


    handleInput = event => {
        const {value,name} = event.target;
        console.log(value);
        this.setState({
            [name]:value
        })
    }

   handleSubmit2 = event => {
    this.props.history.push("/updateUser")

   }

   handleSubmit3 = event => {
    this.props.history.push("/AddNewUser")

   }
   
     handleSubmit1 = event => {
       
         event.preventDefault();
         //trebuie sa se numeasca la fel ca in java in dto
       
         axiosInstance.delete("http://localhost:8080/user/" + this.state.idUser)
        .then(
             res => {
                 console.log(res.data.id)
               
                 console.log(res.data);
             }
         )
         .catch(error => {
             console.log(error)
         });
         window.location.href = "/ListaUser"
     }

    
     render() {
        
        if( localStorage.getItem("ROLE") === "ADMIN")
            {
            
        
        return (

           
            <React.Fragment> 
              <div>
               
               </div>

           

                <List>
                    {this.state.users.map(user => (
                      
                        <ListItem>

                            
                            <Avatar>{"U"}</Avatar>
                            <ListItemText primary = { user.id+ " " + user.username +  " " +
                            user.email 
    
                            
                           
                             }
                            
                            secondary = { user.codactivare + " " + user.rol + " " + user.activ + " " }/>

                             {user.activ === true ?
                             <div>
                                 Acest user este online
                                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                             </div>
                             :
                             <div>
                                 Acest user este offline
                                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </div>}

                           
                           
                         <form onSubmit={this.handleSubmit1}>
                            <Button
                           onClick={() => {
                            this.ceva(user.id);
                          }}
                           
                            variant="contained"
                            color="secondary"
                            id="create"
                            type="submit" >
                               Delete
                            </Button>
                         </form>

                         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                         <form onSubmit={this.handleSubmit2}>
                            <Button
                           onClick={() => {
                            localStorage.setItem("IDUSERI", user.id)
                          }}
                           
                            variant="contained"
                            color="secondary"
                            id="create"
                            type="submit" >
                               Edit
                            </Button>
                         </form>



                       
                        
                        </ListItem>  

                    ))}
                </List> 

                <form onSubmit={this.handleSubmit3}>
                            <Button
                            variant="contained"
                            color="secondary"
                            id="create"
                            type="submit" >
                               Adauga un user cu rol de admin 
                            </Button>
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

export default ListUsers;