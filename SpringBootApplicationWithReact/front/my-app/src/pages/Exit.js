import React from 'react'

import { Avatar, Button, List, ListItemIcon, ListItem, ListItemText, Typography, TextField  } from '@material-ui/core';
import axiosInstance from "../axios";
import { makeStyles } from '@material-ui/core/styles';
import GridList from '@material-ui/core/GridList';
import GridListTile from '@material-ui/core/GridListTile';
import GridListTileBar from '@material-ui/core/GridListTileBar';
import IconButton from '@material-ui/core/IconButton';
import InfoIcon from '@material-ui/icons/Info';
import Home from './Home';
import ListUsers from './ListUsers';

class Exit extends React.Component {

    
    constructor(){
        super();
        this.state = {
           
           user:"",
       

    
        }
        

    }

   

    componentDidMount(){
       
        axiosInstance.put("http://localhost:8080/logOut/" + localStorage.getItem("USER_ID"))
        .then(res => {
            const val = res.data;
            this.setState({
                user: val
            });
            console.log(val);
            console.log(this.state.user)
            localStorage.removeItem("USER_ID");
            
        })
        .catch(error => {
            console.log(error)
        })

       
    
    }
 


        

     render() {
        localStorage.removeItem("COUNT");
        localStorage.removeItem("PERMISIUNE");
       // localStorage.removeItem("USER_ID");
        localStorage.removeItem("ROLE");
        localStorage.removeItem("IDPARFUM");
        localStorage.removeItem("EMAIL");
        localStorage.removeItem("IDUSERI");
        localStorage.removeItem("COD");
        localStorage.removeItem("COD_ACTIVARE");
        localStorage.removeItem("FORGOT");

        

        
        return (
            <div>
                  <Home/>
                 
                
                  
            </div>
            
           
               
                
                    
        )
                                    
                    
    }


}

export default Exit;