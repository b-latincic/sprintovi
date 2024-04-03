import React from 'react';
import { createRoot } from 'react-dom/client';
import { Route, Link, BrowserRouter as Router, Routes } from 'react-router-dom';
import Login from './components/authorization/Login';
import Home from './components/Home';
import AddZadaci from './components/zadaci/AddZadaci';
import Zadaci from './components/zadaci/Zadaci';
import { logout } from './services/auth';
import { Button, Container, Nav, Navbar, NavbarBrand } from 'react-bootstrap'
import EditZadatak from './components/zadaci/EditZadatak';


const App = () => {

    const isUlogovan = localStorage.getItem("jwt");



    return (
        <Container>

   
      <div>
            <Router>
            <Navbar expand bg="dark" variant="dark">
          <Navbar.Brand as={Link} to="/">Home</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">

            <Nav className="ml-auto">
              <Nav.Item>
                {isUlogovan ?
                  <Button variant="primary" onClick={logout}>Logout</Button>
                  :
                  <Nav.Link as={Link} to="/login">Login</Nav.Link>
                }
              </Nav.Item>
            </Nav>
          </Navbar.Collapse>
        </Navbar>
                <Routes>
                    <Route path="/" element={<Home/>} />
                    <Route path="/zadaci" element={<Zadaci/>} />
                    <Route path="/zadaci/add" element={<AddZadaci/>} />
                    <Route path="/login" element={<Login />} />
                    <Route path="/zadaci/:id" element={<EditZadatak />} />

                </Routes>
            </Router>
        </div>
        </Container>
  );

  
}

const rootElement = document.getElementById('root');
const root = createRoot(rootElement);

root.render(
    <App />,
);

