push 0
push 0
push classB
new
push 5
push 1
push classA
new
push 3
push 1
push classC
new
lfp
push -4
lfp
add
lw
copy
lw
push 2
add
lc
js
halt

function0:
cfp
lra
push 1
push 0
lfp
add
lw
calchoff
add
lw
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
push 2
srv
sra
pop
sfp
lrv
lra
js

function2:
cfp
lra
push 10
push 1
push classA
new
lfp
push -2
lfp
add
lw
copy
lw
push 0
add
lc
js
lfp
push 1
lfp
add
lw
copy
lw
push 0
add
lc
js
add
srv
pop
sra
pop
pop
sfp
lrv
lra
js

function3:
cfp
lra
lfp
push 0
lfp
add
lw
copy
lw
push 1
add
lc
js
lfp
push 0
lfp
add
lw
copy
lw
push 0
add
lc
js
add
srv
sra
pop
sfp
lrv
lra
js
classA:
function0
function1
classB:
function2
classC:
function0
function1
function3
classnull:
