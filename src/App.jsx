import React from "react";
import styled from "styled-components";
import NavBar from "./components/NavBar";
import TopSection from "./components/TopSection";
import BottomSection from "./components/BottomSection";

function App() {
  return (
    <AppContainer>
      <NavBar />
      <MainContent>
        <TopSection />
        <BottomSection />
      </MainContent>
    </AppContainer>
  );
}

export default App;

const AppContainer = styled.div`
  display: flex;
  flex-direction: column;
  height: 100vh;
`;

const MainContent = styled.div`
  flex: 1;
  display: flex;
  flex-direction: column;
`;
