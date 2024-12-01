import React from "react";
import styled from "styled-components";

function SideLeft() {
  return (
    <SideLeftContainer>
      <DrinkMachine>콜라</DrinkMachine>
      <Sauces>
        <Sauce
          draggable
          onDragStart={(e) => e.dataTransfer.setData("text", "케첩")}
        >
          케첩
        </Sauce>
        <Sauce
          draggable
          onDragStart={(e) => e.dataTransfer.setData("text", "머스타드")}
        >
          머스타드
        </Sauce>
      </Sauces>
      <BreadContainer></BreadContainer>
    </SideLeftContainer>
  );
}

export default SideLeft;

const SideLeftContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 15%;
`;

const DrinkMachine = styled.div`
  width: 80px;
  height: 150px;
  background: #a0a0a0;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 10px;
  margin-bottom: 20px;
`;

const Sauces = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  width: 100%;
`;

const Sauce = styled.div`
  width: 60px;
  height: 60px;
  background: #848383;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 5px;
  margin: 5px;
  cursor: grab;

  &:active {
    cursor: grabbing;
  }
`;

const BreadContainer = styled.div`
  margin-top: 20px;
`;

const Bread = styled.div`
  width: 80px;
  height: 50px;
  background: #d9a647;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 5px;
  font-size: 14px;
  cursor: grab;

  &:active {
    cursor: grabbing;
  }
`;
