import React from "react";
import styled from "styled-components";

function CenterArea({ burger, onDropOnPlate }) {
  const handleDragOver = (e) => e.preventDefault();

  const handleDrop = (e) => {
    const ingredient = e.dataTransfer.getData("text");
    if (ingredient !== "구운 패티") {
      // 구운 패티는 드래그 앤 드롭으로만 처리
      onDropOnPlate(ingredient);
    }
  };

  return (
    <CenterAreaContainer>
      <IngredientRow>
        {["양상추", "치즈", "양파", "토마토"].map((ingredient) => (
          <Ingredient
            key={ingredient}
            draggable
            onDragStart={(e) => e.dataTransfer.setData("text", ingredient)}
          >
            {ingredient}
          </Ingredient>
        ))}
      </IngredientRow>
      <Plate onDragOver={handleDragOver} onDrop={handleDrop}>
        <p>접시</p>
        {burger.map((item, index) => (
          <BurgerIngredient key={index}>{item}</BurgerIngredient>
        ))}
      </Plate>
      <RawPatty
        draggable
        onDragStart={(e) => e.dataTransfer.setData("text", "안 구운 패티")}
      >
        안 구운 패티
      </RawPatty>
    </CenterAreaContainer>
  );
}

export default CenterArea;

const CenterAreaContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 50%;
`;

const IngredientRow = styled.div`
  display: flex;
  justify-content: center;
  margin-bottom: 20px;
`;

const Ingredient = styled.div`
  width: 100px;
  height: 100px;
  background: #d9d9d9;
  display: flex;
  align-items: center;
  justify-content: center;
  margin: 5px;
  border-radius: 10px;
  font-size: 14px;
  cursor: grab;

  &:active {
    cursor: grabbing;
  }
`;

const Plate = styled.div`
  width: 200px;
  height: 200px;
  background: #ffffff;
  border: 2px solid #000;
  border-radius: 50%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`;

const BurgerIngredient = styled.div`
  width: 90%;
  padding: 5px;
  background: #d9d9d9;
  border-radius: 5px;
  margin: 2px 0;
  text-align: center;
`;

const RawPatty = styled.div`
  width: 100px;
  height: 100px;
  background: #d9d9d9;
  display: flex;
  align-items: center;
  justify-content: center;
  margin: 5px;
  border-radius: 10px;
  font-size: 14px;
  cursor: grab;

  &:active {
    cursor: grabbing;
  }
`;
