import React from "react";
import styled from "styled-components";

function NavBar() {
  return <NavBarContainer>포켓몬 푸드트럭</NavBarContainer>;
}

export default NavBar;

const NavBarContainer = styled.div`
  height: 76px;
  background: #d9d9d9;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 24px;
  font-weight: bold;
`;
