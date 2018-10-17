push 0
push function1
push 0
push classA
new
lfp
push -3
lfp
add
lw
copy
lw
push 0
add
lc
js
print
halt

function0:
cfp
lra
lfp
lfp
lw
push -2
lfp
lw
add
lw
js
srv
sra
pop
sfp
lrv
lra
js

function1:
cfp
lra
push 4
srv
sra
pop
sfp
lrv
lra
js
classA:
function0
classnull:
