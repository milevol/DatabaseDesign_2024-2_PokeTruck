import React, { useState } from "react";
import styled from "styled-components";
import SideLeft from "./SideLeft";
import CookingArea from "./CookingArea";

function BottomSection() {
  const [burger, setBurger] = useState([]); // 접시에 올린 재료 관리
  const [pans, setPans] = useState([null, null]); // 후라이팬 상태 (각 칸의 상태)

  // 접시에 재료를 추가
  const handleDropOnPlate = (ingredient, panIndex = null) => {
    if (ingredient !== "안 구운 패티" && ingredient !== "구운 패티") {
      setBurger([...burger, ingredient]);
      return;
    }

    if (ingredient === "안 구운 패티") {
      alert("안 구운 패티는 먼저 후라이팬에서 구워야 합니다!");
      return;
    }

    if (ingredient === "구운 패티") {
      setBurger([...burger, ingredient]);

      if (panIndex !== null) {
        setPans((prevPans) => {
          const updatedPans = [...prevPans];
          updatedPans[panIndex] = null;
          return updatedPans;
        });
      }
    }
  };

  // 후라이팬에 안 구운 패티를 추가
  const handleDropOnPan = (panIndex, ingredient) => {
    if (ingredient === "안 구운 패티") {
      setPans((prevPans) => {
        const updatedPans = [...prevPans];
        updatedPans[panIndex] = { status: "cooking" };
        return updatedPans;
      });

      setTimeout(() => {
        setPans((prevPans) => {
          const updatedPans = [...prevPans];
          updatedPans[panIndex] = { status: "done" };
          return updatedPans;
        });
        alert("패티가 구워졌습니다!");
      }, 2000);
    } else {
      alert("안 구운 패티만 후라이팬에 올릴 수 있습니다!");
    }
  };

  return (
    <BottomSectionContainer>
      <SideLeft />
      <CenterAreaContainer>
        <RowContainer>
          <Bread
            draggable
            onDragStart={(e) => e.dataTransfer.setData("text", "빵")}
          >
            빵
          </Bread>
          <Plate
            onDragOver={(e) => e.preventDefault()}
            onDrop={(e) => {
              const ingredient = e.dataTransfer.getData("text");
              handleDropOnPlate(ingredient);
            }}
          >
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
        </RowContainer>
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
      </CenterAreaContainer>
      <CookingArea
        pans={pans}
        onDropOnPan={handleDropOnPan}
        onDropOnPlate={handleDropOnPlate}
      />
    </BottomSectionContainer>
  );
}

export default BottomSection;

const BottomSectionContainer = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  background: #d9d9d9;
  padding: 10px;
  height: 40vh; /* BottomSection 높이 조정 */
`;

const CenterAreaContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 50%;
`;

const RowContainer = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100%;
  margin-bottom: 20px; /* 접시와 재료 간 간격 */
`;

const Bread = styled.div`
  width: 100px;
  height: 100px;
  background: #f5c27f;
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

const RawPatty = styled.div`
  width: 100px;
  height: 100px;
  background: #d9d9d9;
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

const IngredientRow = styled.div`
  display: flex;
  justify-content: center;
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

const BurgerIngredient = styled.div`
  width: 90%;
  padding: 5px;
  background: #d9d9d9;
  border-radius: 5px;
  margin: 2px 0;
  text-align: center;
`;
