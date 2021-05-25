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
import Link from '@material-ui/core/Link';


class Admin extends React.Component {

    
   

    constructor(){
        super();
        

    
    }


    
    
     render() {
        
        if( localStorage.getItem("ROLE") === "ADMIN")
            {
            
        
        return (
            
           <React.Fragment>
               <h1>
           <a href= "/ListaParfumuri" >
               Lista parfumuri
           </a>
           </h1>
           <h1>
           <a href="/ListaUser" >
               Lista useri
           </a>
           </h1>
           <h1>
           <a href="/ListaComenzi" >
               Lista comenzi
           </a>
           </h1>
           </React.Fragment>
          

                            
        )
    }
    else
    {
        throw new Error("Doar administratorul are acces");
    }
        
                    
                      
                    
    }
}

export default Admin;