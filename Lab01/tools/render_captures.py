from pathlib import Path
import subprocess

from PIL import Image, ImageDraw, ImageFont


ROOT = Path(__file__).resolve().parents[1]
OUT = ROOT / "screenshots"
BIN = ROOT / "out"
OUT.mkdir(exist_ok=True)

FONT_PATHS = [
    Path(r"C:\Windows\Fonts\consola.ttf"),
    Path(r"C:\Windows\Fonts\cour.ttf"),
]
FONT_PATH = next((path for path in FONT_PATHS if path.exists()), None)
FONT = ImageFont.truetype(str(FONT_PATH), 24) if FONT_PATH else ImageFont.load_default()

CASES = {
    "2.2.1-HelloWorld": ("HelloWorld", ""),
    "2.2.5-BasicOperations": ("BasicOperations", "12.5\n2.0\n"),
    "2.2.6-EquationSolver": ("EquationSolver", "3\n1\n-3\n2\n"),
    "6.3-Triangle": ("Triangle", "5\n"),
    "6.4-DaysOfMonth": ("DaysOfMonth", "2\n2000\n"),
    "6.5-ArrayStatistics": ("ArrayStatistics", "4\n4.5\n1.0\n3.0\n2.5\n"),
    "6.6-MatrixAddition": ("MatrixAddition", "2\n2\n1\n2\n3\n4\n5\n6\n7\n8\n"),
}

for name, (class_name, input_text) in CASES.items():
    result = subprocess.run(
        ["java", "-cp", str(BIN), class_name],
        input=input_text,
        text=True,
        capture_output=True,
        check=True,
    )
    output = f"> java -cp out {class_name}\n" + result.stdout.replace("\r\n", "\n")
    lines = output.rstrip("\n").split("\n")
    width = max(900, max(len(line) for line in lines) * 15 + 60)
    height = max(120, len(lines) * 34 + 50)
    image = Image.new("RGB", (width, height), "#111827")
    draw = ImageDraw.Draw(image)
    draw.rectangle((0, 0, width, 42), fill="#1f2937")
    draw.ellipse((16, 15, 28, 27), fill="#ef4444")
    draw.ellipse((36, 15, 48, 27), fill="#f59e0b")
    draw.ellipse((56, 15, 68, 27), fill="#10b981")
    y = 55
    for line in lines:
        draw.text((24, y), line, fill="#f9fafb", font=FONT)
        y += 34
    image.save(OUT / f"{name}.png")
