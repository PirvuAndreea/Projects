import React, { useState } from 'react';
import { Button } from './Button';
import { Link } from 'react-router-dom';
import './Navbar.css';
import Dropdown from './Dropdown';
import ShoppingCartIcon from '@material-ui/icons/ShoppingCart';
import ExitToAppIcon from '@material-ui/icons/ExitToApp';
import Badge from '@material-ui/core/Badge';
import IconButton from '@material-ui/core/IconButton';
import { withStyles } from '@material-ui/core/styles';
import PersonIcon from '@material-ui/icons/Person';

function NavbarTest() {


    const StyledBadge = withStyles((theme) => ({
        badge: {
            right: -3,
            top: 13,
            border: `2px solid ${theme.palette.background.paper}`,
            padding: '0 4px',
        },
    }))(Badge);


    const [click, setClick] = useState(false);
    const [dropdown, setDropdown] = useState(false);

    const handleClick = () => setClick(!click);
    const closeMobileMenu = () => setClick(false);

    const onMouseEnter = () => {
        if (window.innerWidth < 960) {
            setDropdown(false);
        } else {
            setDropdown(true);
        }
    };

    const onMouseLeave = () => {
        if (window.innerWidth < 960) {
            setDropdown(false);
        } else {
            setDropdown(false);
        }
    };



    return (

        <div>
            {localStorage.getItem("USER_ID") === null ?

                <div>
                    <>
                        <nav className='navbar'>
                            <Link to='/' className='navbar-logo' onClick={closeMobileMenu}>
                                WebShop
                          </Link>

                            <div className='menu-icon' onClick={handleClick}>
                                <i className={click ? 'fas fa-times' : 'fas fa-bars'} />
                            </div>
                            <ul className={click ? 'nav-menu active' : 'nav-menu'}>
                                <li className='nav-item'>
                                    <Link to='/' className='nav-links' onClick={closeMobileMenu}>
                                        Home
                                     </Link>
                                </li>
                                <li
                                    className='nav-item'
                                    onMouseEnter={onMouseEnter}
                                    onMouseLeave={onMouseLeave}
                                >
                                    <Link
                                        to='/parfumuri'
                                        className='nav-links'
                                        onClick={closeMobileMenu}
                                    >
                                        Parfumuri <i className='nav-links' />
                                    </Link>
                                </li>

                                <Link to='/shopping' className='nav-links'>
                                    <IconButton aria-label="cart">
                                        <StyledBadge badgeContent={localStorage.getItem("COUNT")} color="secondary">
                                            <ShoppingCartIcon style={{
                                                fontSize: "50px",
                                                color: 'white'
                                            }} />
                                        </StyledBadge>

                                    </IconButton>
                                </Link>

                                <li className='nav-item'>
                                    <Link
                                        to='/contacts'
                                        className='nav-links'
                                        onClick={closeMobileMenu}
                                    >
                                        Contact
                                    </Link>
                                </li>

                                <li className='nav-item'>
                                    <Link
                                        to='/log-in'
                                        className='nav-links'
                                        onClick={closeMobileMenu}
                                    >
                                        Sign In
            </Link>
                                </li>



                                <li>
                                    <Link
                                        to='/sign-up'
                                        className='nav-links-mobile'
                                        onClick={closeMobileMenu}
                                    >
                                        Sign Up
            </Link>
                                </li>




                            </ul>
                            <Button />
                        </nav>
                    </>
                </div>

                :
                <div>
                    <>
                        <nav className='navbar'>
                            <Link to='/' className='navbar-logo' onClick={closeMobileMenu}>
                                WebShop
        </Link>

                            <div className='menu-icon' onClick={handleClick}>
                                <i className={click ? 'fas fa-times' : 'fas fa-bars'} />
                            </div>
                            <ul className={click ? 'nav-menu active' : 'nav-menu'}>
                                <li className='nav-item'>
                                    <Link to='/' className='nav-links' onClick={closeMobileMenu}>
                                        Home
            </Link>
                                </li>
                                <li
                                    className='nav-item'
                                    onMouseEnter={onMouseEnter}
                                    onMouseLeave={onMouseLeave}
                                >
                                    <Link
                                        to='/parfumuri'
                                        className='nav-links'
                                        onClick={closeMobileMenu}
                                    >
                                        Parfumuri <i className='nav-links' />
                                    </Link>

                                    <Link to='/shopping' className='nav-links'>
                                        <IconButton aria-label="cart">
                                            <StyledBadge badgeContent={localStorage.getItem("COUNT")} color="secondary">
                                                <ShoppingCartIcon style={{
                                                    fontSize: "50px",
                                                    color: 'white'
                                                }} />
                                            </StyledBadge>

                                        </IconButton>
                                    </Link>
                                    <Link
                                        to='/wishList'
                                        className='nav-links'
                                        onClick={closeMobileMenu}
                                    >
                                        My Wish List <i className='nav-links' />
                                    </Link>
                                </li>
                                <li className='nav-item'>
                                    <Link
                                        to='/myAccount'
                                        className='nav-links'
                                        onClick={closeMobileMenu}
                                    >
                                        <PersonIcon  style={{
                                                    fontSize: "25px",
                                                    color: 'white'
                                        }}>  </PersonIcon>
                                        My Account
            </Link>
                                </li>
                                <li className='nav-item'>
                                    <Link
                                        to='/contacts'
                                        className='nav-links'
                                        onClick={closeMobileMenu}
                                    >
                                        Contact
            </Link>
                                </li>


                                <li>

                                    <Link to='/exit' className='nav-links'  onClick={() => {
                          
                                        window.location.href="/exit"
                         
                       
                                   }}>
                                        <ExitToAppIcon

                                            fontSize="inherit"
                                            style={{
                                                fontSize: "30px",
                                                color: 'white'
                                            }}
                                        />
                                       
                                    </Link>
                                </li>



                            </ul>

                        </nav>
                    </>




                </div>

            }

        </div>
    );
}

export default NavbarTest;