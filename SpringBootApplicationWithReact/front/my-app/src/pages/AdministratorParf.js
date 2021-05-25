import React, { useState } from "react"
import { Avatar, Button, List, ListItemIcon, ListItem, ListItemText, Typography, TextField, Checkbox } from '@material-ui/core';
import axiosInstance from "../axios";
import { makeStyles } from '@material-ui/core/styles';
import GridList from '@material-ui/core/GridList';
import GridListTile from '@material-ui/core/GridListTile';
import GridListTileBar from '@material-ui/core/GridListTileBar';
import IconButton from '@material-ui/core/IconButton';
import InfoIcon from '@material-ui/icons/Info';
import Filter from '../components/Filter';
import { saveAs } from 'file-saver';


class AdministratorParf extends React.Component {




    constructor() {
        super();
        this.state = {

            parfumuri: [],
            filteredProducts: [],

            review: {
                id: 0,
                autor0: "Andreea"
            },
            idParfum: 0,
            // idReview : 0,
            autor: "",
            mesaj: "",

            idParf: "",
            displayDetails: false,

            idParf:0,


        }
        this.handleChangeSort = this.handleChangeSort.bind(this)
        this.handleChangeSize = this.handleChangeSize.bind(this)


    }


    ceva(idd) {
        this.setState({ idParf: idd });
    }


    displayDetails = () => {
        this.setState({
            displayDetails: !this.state.displayDetails
        })
        console.log("Buton")
        console.log(this.state.displayDetails)

    }





    componentDidMount() {
        axiosInstance.get("http://localhost:8080/parfum")
            .then(res => {
                const val = res.data;
                this.setState({
                    parfumuri: val,


                });
                console.log(val);
                console.log(this.state.parfumuri)
            }

            )
            .catch(error => {
                console.log(error)
            })

        axiosInstance.get("http://localhost:8080/review/" + this.state.review.autor0)
            .then(res => {
                const val = res.data;
                this.setState({
                    review: val
                });
                console.log(val);
                console.log(this.state.review)
            }

            )
            .catch(error => {
                console.log(error)
            })
    }


    handleInput = event => {
        const { value, name } = event.target;
        console.log(value);
        this.setState({
            [name]: value
        })
    }

    handleSubmit2 = event => {

        this.props.history.push("/updateParfum")

    }

    handleSubmit = event => {

        this.exportData("xml")

    }

    handleSubmit3 = event => {
        this.props.history.push("/AddNewProduct")

    }

    handleSubmit1 = event => {

        event.preventDefault();
        //trebuie sa se numeasca la fel ca in java in dto

        axiosInstance.delete("http://localhost:8080/parfum/" + this.state.idParf)
            .then(
                res => {
                    console.log(res.data.id)

                    console.log(res.data);
                }
            )
            .catch(error => {
                console.log(error)
            });
        window.location.href = "/ListaParfumuri"

    }

    handleChangeSort(event) {
        this.setState({ sort: event.target.value });
        this.listProducts();

    }

    handleChangeSize(event) {
        this.setState({ size: event.target.value });
        this.listProducts();

    }
    handleInput = event => {
        const { value, name } = event.target;
        console.log(value);
        this.setState({
            [name]: value
        })
    }


    listProducts() {
        this.setState(state => {
            if (state.sort !== " ") {
                state.parfumuri.sort((a, b) => (state.sort === "Lowest") ? (a.pret > b.pret ? 1 : -1) : (a.pret < b.pret ? 1 : -1))
            } else if (state.sort === " ") {
                state.parfumuri.sort((a, b) => (a.id > b.id ? 1 : -1));

            }
            if (state.size !== " ") {
                if (state.size === "Armani") {
                    return { parfumuri: state.parfumuri.filter(a => a.producator === "Armani") }
                }
                else if (state.size === "Cristian Dior") {
                    return { parfumuri: state.parfumuri.filter(a => a.producator === "Cristian Dior") }
                }
                else if (state.size === "Carolina") {
                    return { parfumuri: state.parfumuri.filter(a => a.producator === "Carolina") }
                }
            }
            else {
                window.location.reload();

            }


            return { parfumuri: state.parfumuri };

        })
    }
    exportData(fileType) {
        axiosInstance.get("/parfum/export/" + this.state.idParf, { params: { fileType: fileType }, responseType: 'text' })
            .then(res => {
                let typeForBlob = fileType == 'txt' ? 'text/plain;charset=utf-8' : 'text/xml;charset=utf-8';
                let blob = new Blob([res.data], { type: typeForBlob });
                saveAs(blob, "parfum-data." + fileType);
                console.log(blob);

            })
            .catch(error => {
                console.log(error);
            })
    }

    render() {

        if (localStorage.getItem("ROLE") === "ADMIN") {


            return (


                <React.Fragment>
                    <div>
                        <hr />
                        <Filter size={this.state.size} sort={this.state.sort} handleChangeSize={this.handleChangeSize}
                            handleChangeSort={this.handleChangeSort} count={this.state.filteredProducts.length} />

                        <hr />
                    </div>



                    <List>
                        {this.state.parfumuri.map(parfum => (

                            <ListItem>

                                <img src={parfum.filename} alt={parfum.numeparfum} height="100" width="100" />

                                <ListItemText primary={parfum.id + " " + parfum.numeparfum + " " + parfum.producator + " " +
                                    parfum.pret + " "



                                }

                                    secondary={"Review-uri: " + parfum.reviewList.map(review => review.mesaj + " ")} />




                                <form onSubmit={this.handleSubmit1}>
                                    <Button
                                        onClick={() => {
                                            this.ceva(parfum.id);
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
                                            localStorage.setItem("IDPARFUM", parfum.id)
                                        }}

                                        variant="contained"
                                        color="secondary"
                                        id="create"
                                        type="submit" >
                                        Edit
                            </Button>
                                </form>

                         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                                
                               

                            </ListItem>

                        ))}
                    </List>

                    <form onSubmit={this.handleSubmit3}>
                        <Button
                            variant="contained"
                            color="secondary"
                            id="create"
                            type="submit" >
                            Adauga un parfum nou
                            </Button>
                    </form>
                   <br></br>
                    <Button onClick={() =>   this.displayDetails()}
                     variant="contained"
                     color="secondary"
                     id="create"
                     type="submit" >
                                   Exportare date XML
                                </Button>
                             


                                {this.state.displayDetails ?
                                 <form onSubmit={this.handleSubmit}>
                                 <div>
                                 <Typography
                                     variant="subtitle2"
                                     color="textPrimary"
                                     component="h2"
                                 >
                                      <br></br>
                                     Introduceti id-ul parfumului pentru care exportati:
                     </Typography>
                                 <TextField
                                     required={true}
                                    
                                     id="required"
                                     label="id Parfum"
                                     name="idParf"
                                     placeholder="idParf"
                                     onChange={this.handleInput}
                                     margin="normal"
                                     variant="outlined"
                                     autoComplete="off"
                                 />
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
                            Adauga id
              </Button>
                    </div>
                             </form>
                                :null}

                 



                </React.Fragment>



            )
        }
        else {
            throw new Error("Doar administratorul are acces");
        }




    }
}

export default AdministratorParf;